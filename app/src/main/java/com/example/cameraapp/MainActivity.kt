package com.example.cameraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cameraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

    }
}