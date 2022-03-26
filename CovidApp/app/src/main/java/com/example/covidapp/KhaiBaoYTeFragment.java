package com.example.covidapp;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhaiBaoYTeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhaiBaoYTeFragment extends Fragment {

    private View mView;
    private AppCompatButton btn;
    private FoldingCell fc;
    private Button btnExtend;
    private Button btnColab;
    public KhaiBaoYTeFragment() {
    }

    public static KhaiBaoYTeFragment newInstance(String param1, String param2) {
        KhaiBaoYTeFragment fragment = new KhaiBaoYTeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_khai_bao_y_te, container, false);
        anhXa();
        return mView;
    }

    private void anhXa()
    {
        fc= (FoldingCell) mView.findViewById(R.id.folding_cell);
        btnExtend = (Button) mView.findViewById(R.id.btnExtend);
        btnColab = (Button) mView.findViewById(R.id.btnColab);
        btnExtend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
        btnColab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
    }

}