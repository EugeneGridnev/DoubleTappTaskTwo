package com.dttasktwo.doubletapptasktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.dttasktwo.doubletapptasktwo.databinding.ActivityFirstBinding
import kotlin.properties.Delegates.notNull

class FirstActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFirstBinding

    private var counter by notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.firstButton.setOnClickListener {  }

        counter = savedInstanceState?.getInt(COUNTER_KEY) ?: 0
        binding.tvFirstNumber.text = counter.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        increment()
        outState.putInt(COUNTER_KEY, counter)
    }

    private fun increment() {
        counter++
        binding.tvFirstNumber.text = counter.toString()
    }

    companion object {
        @JvmStatic private val COUNTER_KEY = "COUNTER"
    }
}