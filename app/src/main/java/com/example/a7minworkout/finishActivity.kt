package com.example.a7minworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minworkout.databinding.ActivityFinishBinding

class finishActivity : AppCompatActivity() {

    private var binding:ActivityFinishBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        binding= ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)


       setSupportActionBar(binding?.toolFinishActivity)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolFinishActivity?.setNavigationOnClickListener{
            onBackPressed()
        }







    }
}