package com.example.modul7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginRight

class ImageActivity : AppCompatActivity() {
    private val pics = arrayOf(
        R.drawable.pics1,
        R.drawable.pics2,
        R.drawable.pics3,

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        supportActionBar?.hide()//ngilangin bar atas
// Setup Variable
        val gallery = findViewById(R.id.gallery) as Gallery
        val image = findViewById(R.id.imageView) as ImageView
        val audiobtn = findViewById(R.id.image_audio) as Button
        val videobtn = findViewById(R.id.image_video) as Button
// Set Image Gallery
        gallery.adapter = ImageAdapter(this)
        gallery.setOnItemClickListener { _, _, arg2, _ ->
            Toast.makeText(
                baseContext,
                "You have selected picture " + (arg2 + 1) + " from gallery ",
                Toast.LENGTH_SHORT
            ).show()
            image.setImageResource(pics[arg2])
        }
        audiobtn.setOnClickListener{
            val next = Intent(this, AudioActivity::class.java)
            startActivity(next)
        }
        videobtn.setOnClickListener{
            val next = Intent(this, VideoActivity::class.java)
            startActivity(next)
        }
    }

    inner class ImageAdapter(private val ctx: Context) : BaseAdapter() {
        init {
            val galleryContainer =
                obtainStyledAttributes(R.styleable.Gallery)
            galleryContainer.recycle()
        }

        override fun getCount(): Int = pics.size
        override fun getItem(arg0: Int): Any = arg0
        override fun getItemId(arg0: Int): Long = arg0.toLong()
        override fun getView(arg0: Int, arg1: View?, arg2: ViewGroup?):
                View {
            val image = ImageView(ctx)
            image.setImageResource(pics[arg0])
            image.scaleType = ImageView.ScaleType.FIT_START
            image.layoutParams = Gallery.LayoutParams(500, 370)
            return image
        }
    }
}