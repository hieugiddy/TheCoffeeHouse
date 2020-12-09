package com.hieu.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TinTucDetail extends AppCompatActivity {
    TextView tieude,h1_tieude;
    ImageView anh,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tintuc_detail);
        tieude=findViewById(R.id.tieude);
        back=findViewById(R.id.back);
        h1_tieude=findViewById(R.id.h1_tieude);
        anh=findViewById(R.id.anhbaiviet);
        Intent intent=this.getIntent();
        String it_tieude=intent.getStringExtra("tieude");
        String mota=intent.getStringExtra("mota");
        int image=intent.getIntExtra("hinhanh",1);
        tieude.setText(it_tieude);
        h1_tieude.setText(it_tieude);
        anh.setImageResource(image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
