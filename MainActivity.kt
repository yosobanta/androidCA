package com.example.ca1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var name: EditText = findViewById(R.id.name)
        var regnNo: EditText = findViewById(R.id.regnNo)
        var total: EditText = findViewById(R.id.total)
        var attend : EditText = findViewById(R.id.attended)
        var submit : Button = findViewById(R.id.submit)
        var textView : TextView = findViewById(R.id.textView)
        submit.setOnClickListener {
            var name = name.text.toString()
            var regnNo = regnNo.text.toString()
            var total = total.text.toString()
            var attend = attend.text.toString()
            if(total.isEmpty() || attend.isEmpty()){
                Toast.makeText(applicationContext,"Please enter all fields",Toast.LENGTH_SHORT).show()
            }
            var percentage = (attend.toDouble() / total.toDouble()) * 100
            if(percentage>=75){
                Toast.makeText(applicationContext,"You are Eligible",Toast.LENGTH_SHORT).show()
                var display = """
                    Name: $name,Registration Number: $regnNo
                                ELIGIBLE($percentage%)
                """.trimIndent()
                textView.text = display
            }
            else {
                Toast.makeText(applicationContext, "You are not Eligible", Toast.LENGTH_SHORT).show()
                var display = """
                    Name: $name,Registration Number: $regnNo
                                NOT ELIGIBLE($percentage%)
                """.trimIndent()
                textView.text = display
            }


        }




    }
}