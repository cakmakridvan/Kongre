package com.rota.kongresistem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rota.kongresistem.fragment.Tab1;
import com.rota.kongresistem.fragment.Tab2;
import com.rota.kongresistem.fragment.Tab3;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tab1();
            case 1: return new Tab2();
            case 2: return new Tab3();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override    public CharSequence getPageTitle(int position) {switch (position){
        case 0: return "26 Haziran";
        case 1: return "27 Haziran";
        case 2: return "28 Haziran";
        default: return null;
    }
    }
}
