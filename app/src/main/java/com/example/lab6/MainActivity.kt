package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab6.databinding.ActivityMainBinding
import com.github.javafaker.Faker

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list: MutableList<Shape> = mutableListOf()
    private val faker: Faker = Faker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ShapeAdapter(layoutInflater) {
            val dialog = Dialog.getNumber(it.number)
            dialog.show(supportFragmentManager,"dlg")
        }
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this,4)
        adapter.submitList(null)
        for(i in 1..32){
            val place = Shape(faker.number().numberBetween(1,99),faker.color().hex())
            list.add(place)
            adapter.submitList(list.toList())
        }
    }
    data class Shape(val number: Int, val color: String)
}