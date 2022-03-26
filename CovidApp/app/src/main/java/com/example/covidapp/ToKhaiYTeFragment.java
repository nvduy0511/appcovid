package com.example.covidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covidapp.adapter.ToKhaiYTeAdapter;
import com.example.covidapp.model.ToKhaiYTe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToKhaiYTeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToKhaiYTeFragment extends Fragment {

    private View view_ToKhaiYTe;

    private RecyclerView rcv_ToKhaiYTe;
    private ToKhaiYTeAdapter toKhaiYTeAdapter;

    public static ToKhaiYTeFragment newInstance(String param1, String param2) {
        ToKhaiYTeFragment fragment = new ToKhaiYTeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_ToKhaiYTe =  inflater.inflate(R.layout.fragment_to_khai_y_te, container, false);

        // RecyclerView
        rcv_ToKhaiYTe = view_ToKhaiYTe.findViewById(R.id.rcv_ToKhai);
        toKhaiYTeAdapter = new ToKhaiYTeAdapter(this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext() , RecyclerView.VERTICAL, false );
        rcv_ToKhaiYTe.setLayoutManager(linearLayoutManager);
        toKhaiYTeAdapter.setData(getLsToKhai());
        rcv_ToKhaiYTe.setAdapter(toKhaiYTeAdapter);
        return view_ToKhaiYTe;
    }

    private List<ToKhaiYTe> getLsToKhai() {
        List<ToKhaiYTe> ls = new ArrayList<>();
        ls.add(new ToKhaiYTe("20/12/2020","19:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("19/05/2021","07:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("22/11/2022","12:20:30","Phạm Văn B" ));
        ls.add(new ToKhaiYTe("23/04/2022","13:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("22/01/2021","14:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("20/12/2020","15:20:30","Nguyễn Văn Duy" ));

        ls.add(new ToKhaiYTe("20/12/2020","19:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("19/05/2021","07:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("22/11/2022","12:20:30","Phạm Văn B" ));
        ls.add(new ToKhaiYTe("23/04/2022","13:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("22/01/2021","14:20:30","Nguyễn Văn Duy" ));
        ls.add(new ToKhaiYTe("20/12/2020","15:20:30","Nguyễn Văn Duy" ));
        return ls;
    }
}