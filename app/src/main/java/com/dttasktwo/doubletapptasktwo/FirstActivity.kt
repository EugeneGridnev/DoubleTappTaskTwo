package com.dttasktwo.doubletapptasktwo

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dttasktwo.doubletapptasktwo.databinding.ActivityFirstBinding
import kotlin.properties.Delegates.notNull

class FirstActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFirstBinding

    private var counter by notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Активити 1: onCreate")
        binding = ActivityFirstBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.firstButton.setOnClickListener { onButtonPressed() }

        counter = savedInstanceState?.getInt(COUNTER_KEY) ?: 0
        binding.tvFirstNumber.text = counter.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Активити 1: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Активити 1: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Активити 1: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Активити 1: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Активити 1: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Активити 1: onDestroy")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        increment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "Активити 1: onSaveInstanceState counter = $counter")
        outState.putInt(COUNTER_KEY, counter)
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

    companion object {
        @JvmStatic val COUNTER_KEY = "COUNTER"
        private const val TAG = "FirstLifecycleActivity"
    }
}