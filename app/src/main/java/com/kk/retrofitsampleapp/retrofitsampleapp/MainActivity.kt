package com.kk.retrofitsampleapp.retrofitsampleapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.io.IOException

// 3. 実際に呼び出す
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        try {
            val response = RetrofitInstance().create(ApiService::class.java)
            val user = User("taro")
            response.createUser(user)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
