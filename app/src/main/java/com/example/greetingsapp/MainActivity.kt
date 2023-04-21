package com.example.greetingsapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.greetingsapp.data.Person
import com.example.greetingsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.sayHelloBtn.setOnClickListener {
            //Hide Keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken,0)

            //Do this
            val name = binding.editTextTextPersonName.text
            binding.displayGreetingsTextView.text = getString(R.string.greeting,name)
            binding.displayGreetingsTextView.visibility = View.VISIBLE

            //Hide everything else
            binding.sayHelloBtn.visibility = View.GONE
            binding.editTextTextPersonName.visibility = View.GONE

            //set back link visible
            binding.backLinkTextView.visibility = View.VISIBLE
        }
        binding.backLinkTextView.setOnClickListener{
            binding.displayGreetingsTextView.visibility = View.GONE
            binding.sayHelloBtn.visibility = View.VISIBLE
            binding.editTextTextPersonName.visibility = View.VISIBLE
            binding.backLinkTextView.visibility = View.INVISIBLE
        }
//        binding.myData = Person("Juma",5)
    }
}