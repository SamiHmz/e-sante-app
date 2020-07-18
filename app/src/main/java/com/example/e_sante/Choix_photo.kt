package com.example.e_sante

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat.checkSelfPermission
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import kotlinx.android.synthetic.main.fragment_choix_photo.*

class Choix_photo : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//BUTTON CLICK
        img_pick_btn.setOnClickListener { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (context?.let { it1 -> ContextCompat.checkSelfPermission(it1,Manifest.permission.READ_EXTERNAL_STORAGE) } ==
                PackageManager.PERMISSION_DENIED){
                //permission denied
                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                //show popup to request runtime permission
                requestPermissions(permissions, PERMISSION_CODE);
            }
            else{
                //permission already granted
                pickImageFromGallery();
            }
        }
        else{
            //system OS is < Marshmallow
            pickImageFromGallery();
        }

        }
    }
private fun pickImageFromGallery() {
    //Intent to pick image
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    startActivityForResult(intent, IMAGE_PICK_CODE)
}

companion object {
    //image pick code
    private val IMAGE_PICK_CODE = 1000;
    //Permission code
    private val PERMISSION_CODE = 1001;
}

//handle requested permission result
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    when(requestCode){
        PERMISSION_CODE -> {
            if (grantResults.size >0 && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED){
                //permission from popup granted
                pickImageFromGallery()
            }
            else{
                //permission from popup denied
                Toast.makeText(activity?.applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

//handle result of picked image
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
        image_view.setImageURI(data?.data)

        // Get the Image from data
        val selectedImage = data!!.data

    }
}
}
