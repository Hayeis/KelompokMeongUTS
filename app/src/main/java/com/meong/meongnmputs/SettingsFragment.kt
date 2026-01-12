package com.meong.meongnmputs

import android.content.Context
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_fragment)

        val switchNight = findViewById<Switch>(R.id.switchNight)
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)

        // Set posisi switch
        switchNight.isChecked = prefs.getBoolean("night_mode", false)

        switchNight.setOnCheckedChangeListener { _, checked ->
            prefs.edit().putBoolean("night_mode", checked).apply()

            AppCompatDelegate.setDefaultNightMode(
                if (checked)
                    AppCompatDelegate.MODE_NIGHT_YES
                else
                    AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }
}
