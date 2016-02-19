package com.qianfeng.red.biechipang.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.qianfeng.red.biechipang.R;
import com.qianfeng.red.biechipang.activity.BaseActivity;
import com.qianfeng.red.biechipang.main.utils.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private Button btn;
    private List<ImageView> imgList;
    private GuidePagerAdapter adapter;
    public static final int LEFT_MARGIN = 40;
    private View redPointView;
    private int[] imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initView();
    }

    //初始化数据
    private void initView(){
        viewPager = (ViewPager) findViewById(R.id.splash_content_vp);
        btn = (Button)findViewById(R.id.splash_btn);
        adapter = new GuidePagerAdapter();
        viewPager.setAdapter(adapter);
        adapter.setData(imgList);
        //设置监听
        viewPager.setOnPageChangeListener(new MyPagerChangeListener());
        btn.setOnClickListener(this);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        //灰色的原点的数量由ViewPager的页面的数量来定
        for (int i = 0; i < imgs.length; i++){
            View view = new View(this);
            //任何的View对象都有背景属性
            view.setBackgroundResource(R.drawable.white_point);
            //创建View对象从参数对象  宽：20  高：20   注意：在java代码中，如果没有特别的说明，则一般单位都是px
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20, 20);
            params.leftMargin = LEFT_MARGIN * i;
            view.setLayoutParams(params);
            container.addView(view);
        }
        redPointView = new View(this);
        redPointView.setBackgroundResource(R.drawable.red_point);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20, 20);
        redPointView.setLayoutParams(params);
        container.addView(redPointView);

    }

    private void initData(){
        imgs = new int[]{R.drawable.novice1,R.drawable.novice2,R.drawable.novice3};
        imgList = new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imgs[i]);
            imgList.add(imageView);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.splash_btn:
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                SharedPreferenceUtil.putString(SharedPreferenceUtil.SHARE_NAME, "123");
                finish();
                break;
        }
    }


    public class GuidePagerAdapter extends PagerAdapter{
        private List<ImageView> views;
        public void setData(List<ImageView> views){
            this.views = views;
            this.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return views == null?0:views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

    //为滑动的点设置监听
    private class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //获得当前控件的布局参数
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) redPointView.getLayoutParams();

            params.leftMargin = (int) (LEFT_MARGIN * position + LEFT_MARGIN * positionOffset);
            //更改完参数之后，必须重新把参数设置给View对象，才能生效
            redPointView.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int position) {
            if(imgs.length-1 == position){
                btn.setVisibility(View.VISIBLE);

            }else{
                btn.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
