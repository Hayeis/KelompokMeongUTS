package com.meong.meongnmputs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meong.meongnmputs.databinding.ActivityUserAdapterBinding

class UserAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUserAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}