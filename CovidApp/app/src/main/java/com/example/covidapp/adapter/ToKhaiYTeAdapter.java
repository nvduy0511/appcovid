package com.example.covidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.model.ToKhaiYTe;

import java.util.List;

public class ToKhaiYTeAdapter extends RecyclerView.Adapter<ToKhaiYTeAdapter.ToKhaiYTeViewHolder> {

    private Context mContext;
    private List<ToKhaiYTe> lsToKhaiYte;

    public ToKhaiYTeAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<ToKhaiYTe> ls)
    {
        this.lsToKhaiYte = ls;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToKhaiYTeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieukhaibaoyte,parent,false);
        return new ToKhaiYTeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToKhaiYTeViewHolder holder, int position) {
        ToKhaiYTe toKhai = lsToKhaiYte.get(position);
        if(toKhai == null)
        {
            return;
        }
        String res[] = toKhai.getDate().split("/");
        holder.tvDayMonth.setText(res[0]+"/"+res[1]);
        holder.tvYear.setText(res[2]);
        holder.tvName.setText(toKhai.getName());
        holder.tvTime.setText(toKhai.getTime());
    }

    @Override
    public int getItemCount() {
        if(lsToKhaiYte != null)
            return lsToKhaiYte.size();

        return 0;
    }

    public class ToKhaiYTeViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDayMonth;
        private TextView tvYear;
        private TextView tvName;
        private TextView tvTime;
        public ToKhaiYTeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDayMonth = (TextView) itemView.findViewById(R.id.tv_daymonth);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }
}
