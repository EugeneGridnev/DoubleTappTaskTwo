package com.dttasktwo.doubletapptasktwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dttasktwo.doubletapptasktwo.FirstActivity.Companion.COUNTER_KEY
import com.dttasktwo.doubletapptasktwo.databinding.ActivitySecondBinding
import kotlin.math.pow
import kotlin.properties.Delegates.notNull

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private var sqr by notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Активити 2: onCreate")
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        sqr = intent.getIntExtra(COUNTER_KEY,0)
        binding.tvResult.text = sqr.toDouble().pow(power).toInt().toString()
        binding.secondButton.setOnClickListener { onButtonPressed() }

    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Активити 2: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Активити 2: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Активити 2: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Активити 2: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Активити 2: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Активити 2: onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "Активити 2: onSaveInstanceState")
    }

    private fun onButtonPressed() {
        val intent = Intent(this, FirstActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }


     companion object {
        private const val power = 2
        private const val TAG = "SecondLifecycleActivity"
     }
}

