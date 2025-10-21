package com.meong.meongnmputs

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.meong.meongnmputs.databinding.ActivityDetailBinding
import android.view.View
import androidx.appcompat.app.AlertDialog
import android.graphics.Color
import android.content.res.ColorStateList


class DetailActivity : AppCompatActivity() {
    companion object{
        var jumlahFriend = 0
    }
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ambil data-data
        val nama = intent.getStringExtra("nama")
        val nrp = intent.getStringExtra("nrp")
        val aboutMe = intent.getStringExtra("aboutMe")
        val myCourse = intent.getStringExtra("myCourse")
        val myExperience = intent.getStringExtra("myExperience")
        val prodi = intent.getStringExtra("prodi")
        val imageId = intent.getIntExtra("imageId", 0)

        val details = arrayOf("About Me", "My Course", "My Experiences")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, details)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinDetail.adapter = adapter

        binding.btnAddFriend.setOnClickListener {
            jumlahFriend = jumlahFriend + 1
            AlertDialog.Builder(this)
                .setTitle("FRIEND REQUEST")
                .setMessage("Anda Telah Berhasil menambahkan " + nama + " sebagai teman.\nTeman anda sekarang adalah " + jumlahFriend)

            binding.btnAddFriend.backgroundTintList = ColorStateList.valueOf(Color.GREEN)

            binding.btnAddFriend.text = "FRIEND"
        }

        binding.spinDetail.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (details[position] == "About Me") {
                    binding.txtDetail.text = aboutMe
                } else if (details[position] == "My Course") {
                    binding.txtDetail.text = myCourse
                } else if (details[position] == "My Experiences") {
                    binding.txtDetail.text = myExperience
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.txtDetail.text = aboutMe
            }
        }

        binding.txtNama.text = nama
        binding.txtNrp.text = "NRP :\t" + nrp
        binding.gbrMhs.setImageResource(imageId)

        //Radio button prodi
        if (prodi.equals("DSAI", ignoreCase = true)) {
            binding.btnDSAI.isChecked = true
        } else if (prodi.equals("NCS", ignoreCase = true)) {
            binding.btnNCS.isChecked = true
        } else if (prodi.equals("IMES", ignoreCase = true)) {
            binding.btnIMES.isChecked = true
        } else if (prodi.equals("DMT", ignoreCase = true)) {
            binding.btnDMT.isChecked = true
        } else if (prodi.equals("GD", ignoreCase = true)) {
            binding.btnGD.isChecked = true
        } else {
            binding.radioGroup.clearCheck()
        }

    }
}