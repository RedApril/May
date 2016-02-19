package com.qianfeng.red.biechipang.jianzhiqu.ui;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.red.biechipang.R;

/**
 * Created by Administrator on 16-2-16.
 */
public class jaqFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jzq,container,false);
        return view;
    }
}
