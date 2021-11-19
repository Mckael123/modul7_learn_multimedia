package com.example.modul7

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class AudioActivity : AppCompatActivity() {
    private var player: MediaPlayer? = null
    private val isPlaying = "Media is playing "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        //menghilangkan bar nama aplikasi diatas
        supportActionBar?.hide()

        //menyiapkan variabel yang akan digunakan
        val btn_song1 :Button     = findViewById(R.id.play_future)
        val btn_song2 :Button     = findViewById(R.id.play_running)
        val textplay  :TextView   = findViewById(R.id.now_play)
        val bgmusic   :ImageView  = findViewById(R.id.playlistBG)
        val audio_image_btn: Button   = findViewById(R.id.audio_image)
        val audio_video_btn: Button   = findViewById(R.id.audio_video)

        //mengatur fungsi set onlclick saat tombol di tekan

        btn_song1.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(arg0: View?) {
                playSound(1)
                textplay.setText("Now Playing : Future - Red Velvet")
                bgmusic.setImageResource(R.drawable.song_future_bg)
            }
        })

        btn_song2.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(arg0: View?) {
                playSound(2)
                textplay.setText("Now Playing : Running - Gaho")
                bgmusic.setImageResource(R.drawable.song_running_bg)
            }
        })

        audio_image_btn.setOnClickListener{
            val next = Intent(this, ImageActivity::class.java)
            startActivity(next)
        }

        audio_video_btn.setOnClickListener{
            val next = Intent(this, VideoActivity::class.java)
            startActivity(next)
        }
    }

    override fun onPause() {
        try {
            super.onPause()
            player!!.pause()
        } catch (e: Exception) {
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     fun playSound(music: Int) {
        if (music == 1) {
            Toast.makeText(this, isPlaying + "Future - Redvelvet", Toast.LENGTH_LONG)
                .show()
            player = MediaPlayer.create(this, R.raw.future_red_velvet)
        }
        else if (music == 2){
            Toast.makeText(this, isPlaying + "Running - Gaho", Toast.LENGTH_LONG)
                .show()
            player = MediaPlayer.create(this, R.raw.running_gaho)
        }
        player!!.isLooping = false
        player!!.start()
    }
}