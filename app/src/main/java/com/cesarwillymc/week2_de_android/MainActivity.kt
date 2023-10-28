package com.cesarwillymc.week2_de_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cesarwillymc.week2_de_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private var arrayList = arrayListOf("Hamburguer", "Pizza", "Mexican", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.btnDecide.setOnClickListener {
            dataBinding.txtFood.apply {
                text = arrayList.random()
            }
        }
        dataBinding.btnAddFood.setOnClickListener {
            if (dataBinding.edFood.isNotBlank()) {
                addFood(dataBinding.edFood.text.toString())
                dataBinding.txtFood.text = dataBinding.edFood.text
            } else {
                Toast.makeText(this, getString(R.string.lbl_msm_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun EditText.isNotBlank() = this.text.toString().trim().isNotBlank()
    private fun addFood(text: String) {
        arrayList.add(text)
    }
}