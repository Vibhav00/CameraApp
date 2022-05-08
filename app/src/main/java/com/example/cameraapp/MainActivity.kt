package com.example.cameraapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.example.cameraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null  /** using view binding **/
    private var cameraRequestId=1212
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding?.btn?.setOnClickListener {
          if(ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.CAMERA)==
              PackageManager.PERMISSION_GRANTED)  /** checking for self permission **/
          {
              camera()
          }
        else
          {
              ActivityCompat.
              requestPermissions(this,                      /** requesting for permission **/
                  arrayOf(android.Manifest.permission.CAMERA),
                  cameraRequestId)
          }


        }
    }


    private fun camera()       // function for camera
    {
        val cameraInt= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraInt,cameraRequestId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==cameraRequestId)
        {
            val image:Bitmap= data?.extras?.get("data") as Bitmap   /** making bitmap image */
            binding?.iv?.setImageBitmap(image)
        }
    }

}