package com.hieu.thecoffeehouse;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;
import java.util.List;

public class Slide extends AppCompatActivity {
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private Button buttonOnboardingAction;

    public static final int REQUEST_PERMISSION_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide);
        int checkPermissionLoaction = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (checkPermissionLoaction != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_LOCATION);
        }
        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);

        setupOnboardingItems();
        final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setLayoutOnboardingIndicators();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem() +1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                } else {
                    startActivity(new Intent(getApplicationContext(), DangNhap.class));
                    finish();
                }
            }
        });
    }
    private  void setupOnboardingItems(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem itemPayOnline = new OnboardingItem();
        itemPayOnline.setTitle("Chương trình điểm thưởng");
        itemPayOnline.setDescription("Thưởng thức Cafe hay chơi Game đều được tích điểm");
        itemPayOnline.setImage(R.drawable.resources_images_intro_onboadingbg1);

        OnboardingItem itemOnTheWay = new OnboardingItem();
        itemOnTheWay.setTitle("Giao hàng tận nơi");
        itemOnTheWay.setDescription("Đặt món giao hàng tận nơi trong vòng 30 phút");
        itemOnTheWay.setImage(R.drawable.resources_images_intro_onboadingbg2);

        OnboardingItem itemEatTogether = new OnboardingItem();
        itemEatTogether.setTitle("Gọi món tại bàn");
        itemEatTogether.setDescription("Không cần sắp hàng, đặc quyền khác biệt!");
        itemEatTogether.setImage(R.drawable.resources_images_intro_onboadingbg3);

        OnboardingItem ae = new OnboardingItem();
        ae.setTitle("Tích điểm đổi quà");
        ae.setDescription("Dùng điểm đổi hàng ngàn ưu đãi hấp dẫn");
        ae.setImage(R.drawable.resources_images_intro_onboadingbg4);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOnTheWay);
        onboardingItems.add(itemEatTogether);
        onboardingItems.add(ae);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

    private void setLayoutOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
         layoutParams.setMargins(8,0,8,0);
         for(int i=0; i<indicators.length; i++){
             indicators[i] = new ImageView(getApplicationContext());
             indicators[i].setImageDrawable(ContextCompat.getDrawable(
                     getApplicationContext(),
                     R.drawable.onboarding_indicator_inactive
             ));
             indicators[i].setLayoutParams(layoutParams);
             layoutOnboardingIndicators.addView(indicators[i]);
         }
    }

    private  void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for(int i=0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if(index == onboardingAdapter.getItemCount() - 1){
            buttonOnboardingAction.setText("Bắt đầu trải nghiệm");
        }else{
            buttonOnboardingAction.setText("Tiếp tục");
        }
    }
}





























