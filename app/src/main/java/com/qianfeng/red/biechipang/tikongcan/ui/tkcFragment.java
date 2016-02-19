package com.qianfeng.red.biechipang.tikongcan.ui;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.red.biechipang.R;

/**
 * 体控餐页面
 *
 * A simple {@link Fragment} subclass.
 */
public class tkcFragment extends Fragment {


    public tkcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tkc, container, false);
    }


}
