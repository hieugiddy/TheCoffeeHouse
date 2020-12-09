package com.hieu.thecoffeehouse;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoAnFragment extends Fragment {
    private RecyclerView rcv1,rcv2,rcv3;
    private Rcv_Adapter rcv_adapter1,rcv_adapter2,rcv_adapter3;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.doan_fragment, container, false);
        rcv1 = v.findViewById(R.id.rcv31);
        rcv2 = v.findViewById(R.id.rcv32);
        rcv3 = v.findViewById(R.id.rcv33);
        rcv1.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcv2.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcv3.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcv_adapter1=new Rcv_Adapter();
        rcv_adapter2=new Rcv_Adapter();
        rcv_adapter3=new Rcv_Adapter();
        rcv_adapter1.setData(getList1());
        rcv_adapter2.setData(getList2());
        rcv_adapter3.setData(getList3());
        rcv1.setAdapter(rcv_adapter1);
        rcv2.setAdapter(rcv_adapter2);
        rcv3.setAdapter(rcv_adapter3);
        rcv1.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv1, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Rcv_Item rcv_item= getList1().get(position);
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
        rcv2.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv2, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Rcv_Item rcv_item= getList1().get(position);
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
        rcv3.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv3, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Rcv_Item rcv_item= getList1().get(position);
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
    private List<Rcv_Item> getList1() {
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
    private List<Rcv_Item> getList2() {
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
    private List<Rcv_Item> getList3() {
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
