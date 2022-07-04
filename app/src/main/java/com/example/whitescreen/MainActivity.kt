package com.example.whitescreen

import android.content.ContentResolver
import android.content.Intent
import android.graphics.LightingColorFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.whitescreen.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    val TAG = "MainActivity"
    var multipler_bulb = 0
    var addition_bulb = 0
    var multipler_bb = 0
    var addition_bb = 0
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

        setInitialProgress()
        binding?.seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                multipler_bb = spread(progress)
//                setLighting()
                settingLightTuned(progress)

            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun spread(progress: Int) = (progress * 0x10000 + progress * 0x100 + progress * 0x1)
    private fun setLighting() {
        binding?.imageBackground?.colorFilter = LightingColorFilter(multipler_bb, addition_bb)
//        binding?.imageBackground?.colorFilter = LightingColorFilter(multipler_bulb, addition_bulb)
    }
    private fun settingLightTuned(progress: Int) {
        val bulbMul = spread((progress / 255f * 255f + 0).toInt())
        val bulbAdd = spread((progress / 255f * 200f + 0).toInt())
        val bbMul = spread((progress / 255f * 105f + 150).toInt())
        val bbAdd = spread((progress / 255f * 50f + 0).toInt())

        binding?.imageBackground?.colorFilter = LightingColorFilter(bbMul, bbAdd)
//        image_bulb.colorFilter = LightingColorFilter(bulbMul, bulbAdd)
    }

    private fun setInitialProgress(){
        settingLightTuned(255)
        binding?.seekBar?.progress = 255
    }
}