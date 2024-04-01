package com.example.appgiphy.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.appgiphy.constant.MAIN
import com.example.appgiphy.R
import com.example.appgiphy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var navController: NavController? = null
    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)


        MAIN = this
        navController = Navigation.findNavController(this, R.id.id_nav_host)

    }
}