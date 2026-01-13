package com.meong.meongnmputs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switchNight = view.findViewById<Switch>(R.id.switchNight)

        val prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)

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