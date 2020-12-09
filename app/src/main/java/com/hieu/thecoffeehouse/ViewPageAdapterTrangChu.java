package com.hieu.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapterTrangChu extends FragmentStatePagerAdapter {
    public ViewPageAdapterTrangChu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new TinTucFragment();
            case 2:
                return new DatHangFragment();
            case 3:
                return new CuaHangFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new TinTucFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
