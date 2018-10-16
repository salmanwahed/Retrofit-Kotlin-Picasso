package com.swahed.retrofitpicasso.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import com.swahed.retrofitpicasso.R
import com.swahed.retrofitpicasso.model.GithubUser
import com.swahed.retrofitpicasso.networking.GithubRest
import com.swahed.retrofitpicasso.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private var githubRest:GithubRest?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), INTERNET_PERMISSION)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        githubRest = retrofit.create(GithubRest::class.java)

    }

    fun onFollowerClick(view: View){
        Log.i(Constants.LOG_TAG,"Follower clicked")
        githubRest?.allFollowers?.enqueue(object : Callback<List<GithubUser>>{
            override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                Log.i(Constants.LOG_TAG, "Failure")
            }

            override fun onResponse(call: Call<List<GithubUser>>, response: Response<List<GithubUser>>) {
                Log.i(Constants.LOG_TAG, "Success")
                Log.i(Constants.LOG_TAG, response.message())
                for (user: GithubUser in response.body()!!){
                    Log.i(Constants.LOG_TAG, user.login)
                }
            }
        })
    }

    fun onFollowingClick(view: View){
        Log.i(Constants.LOG_TAG, "Following clicked")
        githubRest?.allFollowing?.enqueue(object : Callback<List<GithubUser>>{
            override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                Log.i(Constants.LOG_TAG, "Failure")

            }

            override fun onResponse(call: Call<List<GithubUser>>, response: Response<List<GithubUser>>) {
                Log.i(Constants.LOG_TAG, "Success")
                Log.i(Constants.LOG_TAG, response.message())
                for (user: GithubUser in response.body()!!){
                    Log.i(Constants.LOG_TAG, user.login)
                }
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            INTERNET_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(Constants.LOG_TAG, "Permission granted")
                }else{
                    Log.i(Constants.LOG_TAG, "Permission denied")
                }
            }
        }
    }

    companion object {
        const val INTERNET_PERMISSION: Int = 0xA
    }
}
