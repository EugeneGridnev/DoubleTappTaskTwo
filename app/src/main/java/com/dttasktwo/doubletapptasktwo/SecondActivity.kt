package com.dttasktwo.doubletapptasktwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dttasktwo.doubletapptasktwo.FirstActivity.Companion.COUNTER_KEY
import com.dttasktwo.doubletapptasktwo.databinding.ActivitySecondBinding
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
    }

    private fun onButtonPressed() {
        val intent = Intent(this, FirstActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }

     companion object {
        private const val power = 2
    }
}

