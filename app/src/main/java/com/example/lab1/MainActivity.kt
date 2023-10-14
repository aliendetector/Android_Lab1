package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var color = ""

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.spinner_item,
            listOf("Red", "Green", "Blue", "Yellow", "Purple")
        )
        adapter.setDropDownViewResource(R.layout.spinner_item)
        binding.spinnerColor.adapter = adapter

        binding.spinnerColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                color = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("key", color)
            startActivity(intent)
        }
    }
}