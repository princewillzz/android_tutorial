package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_basics.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class Basics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basics)


//        findViewById<EditText>(R.id.etVar1).text;



        btnAdd.setOnClickListener {

            val var1: Int;
            val var2: Int;

            try {
                var1 = etVar1.text.toString().toInt()
                var2 = etVar2.text.toString().toInt()

            } catch (e: NumberFormatException) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid Operation")
                    .setMessage("Enter Both number!!")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .setCancelable(false)
                    .show()

                return@setOnClickListener
            }

            val result = (var1 + var2).toString();
            tvResult.text = result


//            try {
//                val var1 = etVar1.text.toString().toInt()
//                val var2 = etVar2.text.toString().toInt()
//
//                val result = (var1 + var2).toString();
//
//                tvResult.text = result
//            } catch (e:NumberFormatException) {
//                print("Here")
//                Toast.makeText(this, "Enter Two Numbers First!!", Toast.LENGTH_SHORT).show()
//            }

        }

        // Intent
        btnGoRed.setOnClickListener {
            val intent = Intent(this, RedActivity::class.java);
            startActivity(intent)
        }

        /// Explicait Intent
        btnBrowse.setOnClickListener {
            val url = etURL.text.toString()
            if(url.isEmpty() || !url.startsWith("http://")) {

                AlertDialog.Builder(this)
                    .setTitle("Invalid")
                    .setMessage("Enter Valid URL!")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .setCancelable(false)
                    .show()
                return@setOnClickListener;
            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btnDial.setOnClickListener {
            val phNo = etPhoneNumber.text.toString()
            if(phNo.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Invalid")
                    .setMessage("Enter Valid number!!")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .setCancelable(false)
                    .show()
                return@setOnClickListener;
            }
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phNo"))
            startActivity(intent)

        }
    }
}