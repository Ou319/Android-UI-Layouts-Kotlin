package com.example.ex6

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val img1:ImageView by lazy { findViewById(R.id.img1) }
    val img2:ImageView by lazy { findViewById(R.id.img2) }
    val img3:ImageView by lazy { findViewById(R.id.img3) }
    val img4:ImageView by lazy { findViewById(R.id.img4) }
    val img5:ImageView by lazy { findViewById(R.id.img5) }
    val img6:ImageView by lazy { findViewById(R.id.img6) }
    val img7:ImageView by lazy { findViewById(R.id.img7) }
    val img8:ImageView by lazy { findViewById(R.id.img8) }
    val mytext:TextView by lazy { findViewById(R.id.mytext) }
    var isclicked:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val myImgWithSubtitle = listOf(
            Pair(img1, "Image 1"),
            Pair(img2, "Image 2"),
            Pair(img3, "Image 3"),
            Pair(img4, "Image 4"),
            Pair(img5, "Image 5"),
            Pair(img6, "Image 6"),
            Pair(img7, "Image 7"),
            Pair(img8, "Image 8")
        )

        myImgWithSubtitle.forEach { imageView ->

           imageView.first.setOnClickListener(){
               myImgWithSubtitle.forEach { img->
                   img.first.setBackgroundColor(Color.TRANSPARENT)
               }
               mytext.text= imageView.second
               imageView.first.setBackgroundColor(Color.RED)
           }
        }


    }
}