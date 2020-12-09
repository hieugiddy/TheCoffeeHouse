package com.hieu.thecoffeehouse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Rcv_Adapter extends RecyclerView.Adapter<Rcv_Adapter.VerticalViewHolder>{
    private List<Rcv_Item> mListUser;
    public void setData(List<Rcv_Item> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item, parent, false);

        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        Rcv_Item hori2 = mListUser.get(position);
        if(hori2 == null){
            return;
        }
        holder.imgAvatar.setImageResource(hori2.getResourceID());
        holder.tvTitle.setText(hori2.getTitle());
        holder.tvGiaTien.setText(hori2.getGiaTien());
    }

    @Override
    public int getItemCount() {
        if(mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvatar;
        private TextView tvTitle;
        private TextView tvGiaTien;


        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGiaTien= itemView.findViewById(R.id.giaTien);
        }
    }


}
