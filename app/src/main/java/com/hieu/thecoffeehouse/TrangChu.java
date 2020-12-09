package com.hieu.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangChu extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);

        mNavigationView = findViewById(R.id.bottom_nav);
        mViewPager = findViewById(R.id.view_pager);

        setUpViewPager();

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.bn_tintuc:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.bn_dathang:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.bn_cuahang:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.bn_taikhoan:
                        mViewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }
    private void setUpViewPager(){
        ViewPageAdapterTrangChu viewPageAdapter = new ViewPageAdapterTrangChu(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPageAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.bn_tintuc).setChecked(true);
                        break;
                    case 2:
                        mNavigationView.getMenu().findItem(R.id.bn_dathang).setChecked(true);
                        break;
                    case 3:
                        mNavigationView.getMenu().findItem(R.id.bn_cuahang).setChecked(true);
                        break;
                    case 4:
                        mNavigationView.getMenu().findItem(R.id.bn_taikhoan).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}