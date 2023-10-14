package com.example.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lab1.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setBackgroundColor(setColorBack(intent.getStringExtra("key").toString()))

        binding.btnBack.setOnClickListener { onBackPressed() }
    }
    private fun setColorBack(name: String): Int{
        binding.tvColor.text = "Color: $name"
        val color = when (name) {
            "Red" -> R.color.red
            "Green" -> R.color.green
            "Blue" -> R.color.blue
            "Yellow" -> R.color.yellow
            "Purple" -> R.color.purple
            else-> R.color.white
        }
        return ContextCompat.getColor(this, color)
    }
}