package com.dttasktwo.doubletapptasktwo

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dttasktwo.doubletapptasktwo.databinding.ActivityFirstBinding
import java.io.IOException
import kotlin.properties.Delegates.notNull

class FirstActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFirstBinding

    private var counter by notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.firstButton.setOnClickListener { onButtonPressed() }

        counter = savedInstanceState?.getInt(COUNTER_KEY) ?: 0
        binding.tvFirstNumber.text = counter.toString()
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
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION + "onDestroy")
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        increment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
        saveActivityStateToFile(FILE_NAME, ACTION_DESCRIPTION +
                "onSaveInstanceState, counter равен: $counter")
    }

    private fun onButtonPressed() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(COUNTER_KEY, counter)
        startActivity(intent)
    }

    private fun increment() {
        counter++
        binding.tvFirstNumber.text = counter.toString()
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
        @JvmStatic val COUNTER_KEY = "COUNTER"
        private const val FILE_NAME = "activity_actions.txt"
        private const val ACTION_DESCRIPTION = "\nАКТИВИТИ 1: "

    }
}