package com.meong.meongnmputs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meong.meongnmputs.databinding.ActivityFriendRequestBinding


class FriendRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFriendRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityFriendRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}