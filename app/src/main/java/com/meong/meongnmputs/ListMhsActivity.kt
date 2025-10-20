package com.meong.meongnmputs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.meong.meongnmputs.databinding.ActivityListMhsBinding

class ListMhsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListMhsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recMhs.layoutManager = LinearLayoutManager(this)
        binding.recMhs.setHasFixedSize(true)

        binding.recMhs.adapter = MahasiswaAdapter{ mahasiswa->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nama", mahasiswa.nama)
            intent.putExtra("nrp", mahasiswa.nrp)
            intent.putExtra("aboutMe", mahasiswa.aboutMe)
            intent.putExtra("myCourse", mahasiswa.myCourse)
            intent.putExtra("myExperience", mahasiswa.myExperience)
            intent.putExtra("prodi", mahasiswa.prodi)
            intent.putExtra("imageId", mahasiswa.imageId)
            startActivity(intent)
        }
    }
}