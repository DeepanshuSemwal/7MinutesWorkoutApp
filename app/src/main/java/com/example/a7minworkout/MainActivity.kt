package com.example.a7minworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minworkout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //val framebtn:FrameLayout=findViewById(R.id.frame_layout)
        binding?.framelayout?.setOnClickListener{
            val intent=Intent(this,ExcerciseActivity::class.java)
            startActivity(intent)

        }

        binding?.frameBmi?.setOnClickListener{
            val intent=Intent(this,BmiActivity::class.java)
            startActivity(intent)
        }
    }
}