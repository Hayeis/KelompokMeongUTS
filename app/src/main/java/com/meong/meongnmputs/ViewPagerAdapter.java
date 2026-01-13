package com.meong.meongnmputs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter {val activity:AppCompatActivity,val fragments:ArrayList<Fragment>):FragmentStateAdapter(activity){


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}

}
