package com.ProyectoZulia.zuliamovil.Login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ViewFlipper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ProyectoZulia.zuliamovil.R

class RegistroandLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registroand_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)

        val btnLoginToggle = findViewById<Button>(R.id.btn_acc)
        val btnRegisterToggle = findViewById<Button>(R.id.btn_reg)

        fun updateActiveButton(active: Button, inactive: Button) {
            active.setBackgroundResource(R.drawable.rounded_button)
            active.setTextColor(Color.WHITE)

            inactive.setBackgroundResource(R.drawable.btnlogsign)
            inactive.setTextColor(ContextCompat.getColor(this, R.color.black))
        }

        btnLoginToggle.setOnClickListener {
            viewFlipper.inAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            viewFlipper.outAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)
            viewFlipper.displayedChild = 0 // Login

            updateActiveButton(btnLoginToggle, btnRegisterToggle)
        }

        btnRegisterToggle.setOnClickListener {
            viewFlipper.inAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
            viewFlipper.outAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
            viewFlipper.displayedChild = 1 // Registro

            updateActiveButton(btnRegisterToggle, btnLoginToggle)
        }


    }
}