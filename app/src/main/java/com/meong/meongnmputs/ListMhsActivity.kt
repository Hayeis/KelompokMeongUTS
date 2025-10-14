package com.meong.meongnmputs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.meong.meongnmputs.databinding.ActivityListMhsBinding

class ListMhsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListMhsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}