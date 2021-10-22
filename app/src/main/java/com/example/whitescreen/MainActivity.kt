package com.example.whitescreen

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.whitescreen.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    val TAG = "MainActivity"
    //Variable to store brightness value
    private var brightness = 0

    //Content resolver used as a handle to the system's settings
    private val cResolver: ContentResolver? = null

    //Window object, that will store a reference to the current window
//    private var window: Window? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        binding?.apply {
            setContentView(root)
        }
        binding?.powerOff?.setOnClickListener {
            finish()
        }
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // change using permission
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!Settings.System.canWrite(this)) {
//                val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
//                intent.data = Uri.parse("package:$packageName")
//                startActivity(intent)
//            }
//        }




//        brightness = Settings.System.getInt(
//            applicationContext.contentResolver,
//            Settings.System.SCREEN_BRIGHTNESS, 0
//        )

//        try{
//            Settings.System.putInt(
//                applicationContext.contentResolver,
//                Settings.System.SCREEN_BRIGHTNESS, 255
//            )
//        }catch (e:Exception){
//            Log.d(TAG, "onCreate: ${e.message}")
//        }



//        binding?.seekBar?.progress = brightness



//        binding?.seekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
//
//                Settings.System.putInt(
//                    applicationContext.contentResolver,
//                    Settings.System.SCREEN_BRIGHTNESS, brightness.toInt()
//                )
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar) {}
//            override fun onStopTrackingTouch(seekBar: SeekBar) {}
//        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}