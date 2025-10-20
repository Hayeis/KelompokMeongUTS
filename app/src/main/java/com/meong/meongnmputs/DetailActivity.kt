package com.meong.meongnmputs

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.meong.meongnmputs.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("nama")
        val nrp = intent.getStringExtra("nrp")
        val aboutMe = intent.getStringExtra("aboutMe")
        val myCourse = intent.getStringExtra("myCourse")
        val myExperience = intent.getStringExtra("myExperience")
        val prodi = intent.getStringExtra("prodi")
        val imageId = intent.getIntExtra("imageId", 0)

        binding.txtNama.text = nama
        binding.txtNrp.text = "NRP :\t" + nrp
        binding.gbrMhs.setImageResource(imageId)
        //binding.imgMhsDtl.sourceLayoutResId = R.drawable

    }
}