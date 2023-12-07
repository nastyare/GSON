package com.example.gson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {
    private lateinit var pic: ImageView
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val link = intent.getStringExtra("link")

        pic = findViewById(R.id.imageView)
        Glide.with(this).load(link).into(pic)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.btn_heart -> {
                sendDataBack()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun sendDataBack() {
        val link = intent.getStringExtra("link")
        val resultIntent = Intent()
        resultIntent.putExtra("link", link)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}