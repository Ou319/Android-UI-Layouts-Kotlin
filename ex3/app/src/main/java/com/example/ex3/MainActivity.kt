package com.example.ex3

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
     val toggleBtn: ToggleButton by lazy { findViewById(R.id.toggleButton) }
     val buttonRed: Button by lazy { findViewById(R.id.button_red) }
     val buttonGreen: Button by lazy { findViewById(R.id.button_green) }
     val buttonYellow: Button by lazy { findViewById(R.id.button_yellow) }
     val buttonReset: Button by lazy { findViewById(R.id.button_reset) }
     val liearview: LinearLayout by lazy { findViewById(R.id.color_buttons_layout) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        toggleBtn.textOn="hide colors"
        toggleBtn.textOff="show colors"
        liearview.visibility=View.GONE

        buttonRed.setOnClickListener {
            window.decorView.setBackgroundColor(Color.RED)
        }
        buttonGreen.setOnClickListener {
            window.decorView.setBackgroundColor(Color.GREEN)
        }
        buttonYellow.setOnClickListener {
            window.decorView.setBackgroundColor(Color.YELLOW)
        }


        toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                liearview.visibility=View.VISIBLE


            } else {
                liearview.visibility=View.GONE


            }
        }
        buttonReset.setOnClickListener(){
            window.decorView.setBackgroundColor(Color.WHITE)
            toggleBtn.isChecked=false
        }
    }
}