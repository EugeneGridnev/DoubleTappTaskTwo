package com.dttasktwo.doubletapptasktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dttasktwo.doubletapptasktwo.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding:ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


    }
}