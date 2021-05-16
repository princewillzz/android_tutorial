package com.example.myfirstapp

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        // Navigator

        btnListPage.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java);
            startActivity(intent)
        }


        btnBasicPage.setOnClickListener {
            val intent = Intent(this, Basics::class.java);
            startActivity(intent)
        }
    }
}