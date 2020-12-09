package com.hieu.thecoffeehouse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;


public class TinTucFragment extends Fragment {
    private RecyclerView rcv2;
    private RecyclerView rcv3;
    private RecyclerView rcv4;

    private Hori2Adapter hori2Adapter;
    private Hori2Adapter hori2Adapter1;
    private Hori2Adapter hori2Adapter2;
    Button dangNhap;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tintuc_fragment, container, false);
        rcv2 = v.findViewById(R.id.rcv2);
        rcv3 = v.findViewById(R.id.rcv3);
        rcv4 = v.findViewById(R.id.rcv4);
        dangNhap = v.findViewById(R.id.dangnhap);
        initRecyclerView();
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),DangNhap.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        rcv2.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv2, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                XemChiTiet(getListHori2(),position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        rcv3.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv3, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                XemChiTiet(getListHori3(),position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        rcv4.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rcv4, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                XemChiTiet(getListHori4(),position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return v;
    }

    public void XemChiTiet(List<Hori2> list,int position){
        Hori2 hori2= list.get(position);
        Intent intent=new Intent(getActivity(), TinTucDetail.class);
        intent.putExtra("tieude",hori2.getTitle());
        intent.putExtra("hinhanh",hori2.getResourceID());
        intent.putExtra("mota",hori2.getMota());
        startActivity(intent);
    }

    private void initRecyclerView(){
        rcv2.setHasFixedSize(true);
        rcv3.setHasFixedSize(true);
        rcv4.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);

        rcv2.setLayoutManager(linearLayoutManager3);
        rcv3.setLayoutManager(linearLayoutManager4);
        rcv4.setLayoutManager(linearLayoutManager5);

        hori2Adapter = new Hori2Adapter();
        hori2Adapter1 = new Hori2Adapter();
        hori2Adapter2 = new Hori2Adapter();


        hori2Adapter.setData(getListHori2());
        hori2Adapter1.setData(getListHori3());
        hori2Adapter2.setData(getListHori4());

        rcv2.setAdapter(hori2Adapter);
        rcv3.setAdapter(hori2Adapter1);
        rcv4.setAdapter(hori2Adapter2);
    }


    private List<Hori2> getListHori2(){
        List<Hori2> list3 = new ArrayList<>();
        list3.add(new Hori2(R.drawable.chabong, "\"Giáng sinh\" Nhà giao, nơi nào cũng tới","Mở app và nhập mã MERRY40, Nhà mời ƯU ĐÃI 40% - để dù ở bắt cứ đâu, bất cứ thời tiết nào"));
        list3.add(new Hori2(R.drawable.my, "Nhà mời 20%, PICKUP nha","Trải nghiệm tính năng PICKUP của Nhà vố ưu đãi GIẢM 20% cho đơn hàng chỉ từ 100k"));
        list3.add(new Hori2(R.drawable.my, "Bánh ngon Nhà mời, chỉ 19.000đ","Cuối năm bận rộn thì cứ, chạy số, chiến Dealline nhưng không được bỏ bữa nha mấy bạn"));
        list3.add(new Hori2(R.drawable.my, "Mua 3 tặng 1 mời nhóm mình chung vui","Chỉ cần nhập mã CUNGVUI qua App, Nhà mời ngay ưu đãi Mua 3 tặng 1 - để team mình"));
        list3.add(new Hori2(R.drawable.my, "Team Hà Nội gọi combo trà mát, Nhà tặng ngay ly xịn xò","Nhận ngay ly nhựa 2 lớp xịn xò phiên bản Nắng Vàng (Quả dứa) và Biển xanh"));
        list3.add(new Hori2(R.drawable.my, "Loạt Deal xịn xò \"Cập bến\" Nhà, Đổi Ngay Thôi","Ngày hội đổi BEAN lớn nhất năm, Deal siêu xịn xò vẫy gọi"));
        return list3;
    }
    private List<Hori2> getListHori3(){
        List<Hori2> list4 = new ArrayList<>();
        list4.add(new Hori2(R.drawable.my, "Nhà Zen Residence Hà Nội khai trương cùng nhiều quà","Nhà mới khai trương vào 04/12 - 07/12, nên còn chờ gì nữa mà không mặc chiếc áo đủ ấm"));
        list4.add(new Hori2(R.drawable.my, "Taste of Xmas - Chạm vị giáng sinh","Năm nay giáng sinh tại Nhà,\"vị\" Giáng sinh mà bạn yêu thích, mong chờ từ truớc đến nay"));
        list4.add(new Hori2(R.drawable.my, "Trời se lạnh thưởng thức những món ngon của Nhà","Chớm đầu Đông, những cơn mưa bất chợt làm trời se lạnh là thời điểm tuyệt vời để nhâm nhi"));
        list4.add(new Hori2(R.drawable.my, "Khám phá không gian Nhà mới: Hiện Đại, Sang Trọng","Mô hình thiểt kế mới tại Nhà mang đến xinh đẹp vừa Xinh vừa Lạ"));
        list4.add(new Hori2(R.drawable.my, "Nhà tặng bạn thêm 3 tháng đổi BEAN nhận ưu đãi","Để đảm bảo quyền lợi và trải nghiệm tốt cho bạn"));

        return list4;
    }
    private List<Hori2> getListHori4(){
        List<Hori2> list5 = new ArrayList<>();
        list5.add(new Hori2(R.drawable.my, "Nhà Zen Residence Hà Nội khai trương cùng nhiều quà","Nhà mới khai trương vào 04/12 - 07/12, nên còn chờ gì nữa mà không mặc chiếc áo đủ ấm"));
        list5.add(new Hori2(R.drawable.my, "Taste of Xmas - Chạm vị giáng sinh","Năm nay giáng sinh tại Nhà,\"vị\" Giáng sinh mà bạn yêu thích, mong chờ từ truớc đến nay"));
        list5.add(new Hori2(R.drawable.my, "Trời se lạnh thưởng thức những món ngon của Nhà","Chớm đầu Đông, những cơn mưa bất chợt làm trời se lạnh là thời điểm tuyệt vời để nhâm nhi"));
        list5.add(new Hori2(R.drawable.my, "Khám phá không gian Nhà mới: Hiện Đại, Sang Trọng","Mô hình thiểt kế mới tại Nhà mang đến xinh đẹp vừa Xinh vừa Lạ"));
        list5.add(new Hori2(R.drawable.my, "Nhà tặng bạn thêm 3 tháng đổi BEAN nhận ưu đãi","Để đảm bảo quyền lợi và trải nghiệm tốt cho bạn"));

        return list5;
    }
}


class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

        public void onLongItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mListener != null) {
                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}

}