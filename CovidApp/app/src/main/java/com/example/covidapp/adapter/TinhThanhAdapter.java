package com.example.covidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.model.TinhThanh;
import com.example.covidapp.model.ToKhaiYTe;

import java.util.List;

public class TinhThanhAdapter extends RecyclerView.Adapter<TinhThanhAdapter.TinhThanhViewHolder> {

    private Context mContext;
    private List<TinhThanh> lsTinhThanh;
    public TinhThanhAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<TinhThanh> ls)
    {
        this.lsTinhThanh = ls;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TinhThanhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_canhiemtinhthanh,parent,false);
        return new TinhThanhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinhThanhViewHolder holder, int position) {
        TinhThanh tinhThanh = lsTinhThanh.get(position);
        if(tinhThanh == null)
        {
            return;
        }
        holder.tvTinhThanh.setText(tinhThanh.getTenTinhThanh());
        holder.tvCaHomNay.setText("+"+tinhThanh.getSoCaNhiem());
        holder.tvTongCanhNhiem.setText(tinhThanh.getTongCaNhiem());
        holder.tvCaTuVong.setText(tinhThanh.getSoCaTuVong());
    }

    @Override
    public int getItemCount() {
        if(lsTinhThanh != null)
            return lsTinhThanh.size();

        return 0;
    }

    public class TinhThanhViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTinhThanh;
        private TextView tvTongCanhNhiem;
        private TextView tvCaHomNay;
        private TextView tvCaTuVong;
        public TinhThanhViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTinhThanh = (TextView) itemView.findViewById(R.id.tvTinhThanh);
            tvTongCanhNhiem = (TextView) itemView.findViewById(R.id.tvTongCaNhiem);
            tvCaHomNay = (TextView) itemView.findViewById(R.id.tvCaNhiemHomNay);
            tvCaTuVong = (TextView) itemView.findViewById(R.id.tvTongCaTuVong);

        }
    }
}
