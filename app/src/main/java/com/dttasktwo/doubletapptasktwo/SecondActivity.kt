package com.dttasktwo.doubletapptasktwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dttasktwo.doubletapptasktwo.FirstActivity.Companion.COUNTER_KEY
import com.dttasktwo.doubletapptasktwo.databinding.ActivitySecondBinding
import java.io.IOException
import kotlin.math.pow
import kotlin.properties.Delegates.notNull

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private var sqr by notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        sqr = intent.getIntExtra(COUNTER_KEY,0)
        binding.tvResult.text = sqr.toDouble().pow(power).toInt().toString()
        binding.secondButton.setOnClickListener { onButtonPressed() }
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onCreate")

    }
    override fun onStart() {
        super.onStart()
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onStart")
    }

    override fun onResume() {
        super.onResume()
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onResume")
    }

    override fun onPause() {
        super.onPause()
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onPause")
    }

    override fun onStop() {
        super.onStop()
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        saveActivityStateToFile(SecondActivity.FILE_NAME, ACTION_DESCRIPTION + "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onSaveInstanceState")
    }

    private fun onButtonPressed() {
        val intent = Intent(this, FirstActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }


    private fun saveActivityStateToFile(fileName: String, actionDescription: String) {
        return try {
            openFileOutput(fileName, MODE_APPEND).use { stream->
                stream.write(actionDescription.toByteArray())
            }
        } catch (exp: IOException) {
            exp.printStackTrace()
        }
    }

     companion object {
        private const val power = 2
         private const val FILE_NAME = "activity_actions.txt"
         private const val ACTION_DESCRIPTION = "\nАКТИВИТИ 2: "
    }
}

