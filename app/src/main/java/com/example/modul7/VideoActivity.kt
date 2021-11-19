package com.example.modul7

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        //menghilangkan bar nama aplikasi diatas
        supportActionBar?.hide()

        //menyiapkan variabel yang akan digunakan
        val videoView = findViewById<View>(R.id.videoView) as VideoView
        val video_audio_btn: Button = findViewById(R.id.video_audio)
        val video_image_btn: Button = findViewById(R.id.video_image)

        video_audio_btn.setOnClickListener{
            val next = Intent(this, AudioActivity::class.java)
            startActivity(next)
        }
        video_image_btn.setOnClickListener{
            val next = Intent(this, ImageActivity::class.java)
            startActivity(next)
        }
        videoView!!.setVideoPath(
            "android.resource://" + packageName + "/" +
                    R.raw.video
        )
        var mc = MediaController(this)
        mc.setMediaPlayer(videoView)
        videoView!!.setMediaController(mc)
        videoView!!.requestFocus()
        videoView!!.start()
    }
}
