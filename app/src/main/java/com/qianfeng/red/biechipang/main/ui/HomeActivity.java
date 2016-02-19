package com.qianfeng.red.biechipang.main.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qianfeng.red.biechipang.R;
import com.qianfeng.red.biechipang.biechipang.ui.bcpFragment;
import com.qianfeng.red.biechipang.jianzhiqu.ui.jaqFragment;
import com.qianfeng.red.biechipang.shoubaike.ui.sbkFragment;
import com.qianfeng.red.biechipang.tikongcan.ui.tkcFragment;

public class HomeActivity extends FragmentActivity {

    private FrameLayout homeFl;
    private RadioGroup homeRg;

    private Fragment[] fragments;
    private FragmentManager manager;
    private int checkIndex;

    private RadioGroup.OnCheckedChangeListener changeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            View radioButton = findViewById(checkedId);
            int index = 0;
            switch (checkedId) {
                case R.id.home_bcp_rb:
                    index = 0;
                    break;
                case R.id.home_sbk_rb:
                    index = 1;
                    break;
                case R.id.home_tkc_rb:
                    index = 2;
                    break;
                case R.id.home_jzq_rb:
                    index = 3;
                    break;
                default:
                    index = 0;
                    break;
            }
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = fragments[index];
            transaction.show(fragment);
            transaction.hide(fragments[checkIndex]);
            transaction.commit();
            checkIndex = index;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeFl = (FrameLayout) findViewById(R.id.home_content_fl);
        homeRg = (RadioGroup) findViewById(R.id.home_rg);

        homeRg.setOnCheckedChangeListener(changeListener);
        // 从RadioGroup中获取第一个RadioButton
        View firstChild = homeRg.getChildAt(0);

        fragments = new Fragment[]{
                new bcpFragment(),
                new sbkFragment(),
                new tkcFragment(),
                new jaqFragment()
        };
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for(int i = 0;i < fragments.length;i++){
            Fragment fragment = fragments[i];
            transaction.add(R.id.home_content_fl,fragment);
            transaction.hide(fragment);
        }
        transaction.show(fragments[0]);
        transaction.commit();
    }
}

