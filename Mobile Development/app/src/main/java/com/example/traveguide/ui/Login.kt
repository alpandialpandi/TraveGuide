package com.example.traveguide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.traveguide.R
import com.example.traveguide.databinding.ActivityLoginBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val listEmail = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val client = AsyncHttpClient()
        val url = "https://traveloginregis-ycf3crjora-et.a.run.app/users"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                val result = String(responseBody)
                try {
                    val jsonArray = JSONArray(result)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val first_name = jsonObject.getString("first_name")
                        listEmail.add(first_name)
                        Log.d(listEmail.toString(), "aaa")
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@Login, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@Login, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnLogin.setOnClickListener {
            if(binding.txtUsername.text.toString() == listEmail.toString()){
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Username or Password Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    companion object {
//        private val TAG = Login::class.java.simpleName
//    }
//
//    private lateinit var binding: ActivityLoginBinding
//
//    private val userViewModel by viewModels<UserViewModel>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        userViewModel.getUser()
//        userViewModel.listUser.observe(this) {
//            Log.d("listUser", it.toString())
//            binding.btnLogin.setOnClickListener {
//                if (binding.txtUsername.text.toString() == userViewModel.toString()) {
//
//                    val intent = Intent(this, Home::class.java)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, "Username or Password Wrong!", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
}