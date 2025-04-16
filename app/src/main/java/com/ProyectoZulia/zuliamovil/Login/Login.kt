package com.ProyectoZulia.zuliamovil.Login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ProyectoZulia.zuliamovil.R
import android.view.View
import android.text.Spanned
import android.text.method.LinkMovementMethod

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton Para redirigir a LoginAndRegister
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginAndRegister::class.java)
            startActivity(intent)
        }

        //Texto que redirige a Register
        val txtView = findViewById<TextView>(R.id.txtRegister)

        val texto = "¿No tienes cuenta? Regístrate"
        val spannable = SpannableString(texto)

        // Cambiar color y hacerlo clickeable solo en "Regístrate"
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@Login, LoginAndRegister::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor("#006D80") // Cambia a tu color
                ds.isUnderlineText = false
            }
        }

        // Aplicar el estilo a la palabra "Regístrate"
        val start = texto.indexOf("Regístrate")
        val end = start + "Regístrate".length
        spannable.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        txtView.text = spannable
        txtView.movementMethod = LinkMovementMethod.getInstance()
        txtView.highlightColor = Color.TRANSPARENT // Quita color feo al pulsar
    }
}