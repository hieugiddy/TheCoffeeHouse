package com.hieu.thecoffeehouse;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class PhoBienFragment extends Fragment {
    private RecyclerView rcv;
    private Rcv_Adapter rcv_adapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.phobien_fragment, container, false);
        rcv = v.findViewById(R.id.rcv);
        rcv.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcv_adapter=new Rcv_Adapter();
        rcv_adapter.setData(getList());
        rcv.setAdapter(rcv_adapter);
        rcv.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Rcv_Item rcv_item= getList().get(position);
                final Dialog dialog= new Dialog(getActivity(),R.style.PauseDialog);
                dialog.setContentView(R.layout.dialog_themgiohang);

                Button datMua=dialog.findViewById(R.id.datmua);
                TextView tieude=dialog.findViewById(R.id.tieude_item);
                ImageView anh=dialog.findViewById(R.id.anh_item);
                TextView gia=dialog.findViewById(R.id.gia_item);
                tieude.setText(rcv_item.getTitle());
                anh.setImageResource(rcv_item.getResourceID());
                gia.setText(rcv_item.getGiaTien());
                datMua.setText(rcv_item.getGiaTien());

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                datMua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return v;
    }

    private List<Rcv_Item> getList() {
        List<Rcv_Item> list = new ArrayList<>();
        list.add(new Rcv_Item(R.drawable.socola,"Sôcôla Lúa Mạch nóng","69.000đ"));
        list.add(new Rcv_Item(R.drawable.socola,"Sôcôla Lúa Mạch đá xoay","69.000đ"));
        list.add(new Rcv_Item(R.drawable.caffe,"Cà phê lúa mạch nóng","69.000đ"));
        list.add(new Rcv_Item(R.drawable.caffe,"Cà phê lúa mạch đá","69.000đ"));
        list.add(new Rcv_Item(R.drawable.caffe,"Cà Phê Sữa Đá","32.000đ"));
        list.add(new Rcv_Item(R.drawable.tradao,"Trà Đào Cam Sả - Đá","45.000đ"));
        list.add(new Rcv_Item(R.drawable.oolong,"Oolong Hạt Sen - Đá","45.000đ"));
        list.add(new Rcv_Item(R.drawable.chabong,"Chà Bông Phô Mai","32.000đ"));
        return list;
    }
}

