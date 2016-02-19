package com.qianfeng.red.biechipang.main.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.qianfeng.red.biechipang.R;
import com.qianfeng.red.biechipang.main.utils.SharedPreferenceUtil;


public class SplashActivity extends Activity {
    private Handler handler;
    private static final int DELAY = 2000;
    private static  final int GO_MAIN = 3000;
    private static  final int GO_GUIDE= 3001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case GO_MAIN:
                        jump(HomeActivity.class,true);
                        break;
                    case GO_GUIDE:
                        jump(GuideActivity.class,true);
                        break;
                }
            }
        };
        init();
    }

    public  void init(){
        String uid = SharedPreferenceUtil.getString(SharedPreferenceUtil.SHARE_NAME,"");
        if(uid!=null&&!uid.equals("")){
            handler.sendEmptyMessageDelayed(GO_MAIN,DELAY);
        }else{
            handler.sendEmptyMessageDelayed(GO_GUIDE,DELAY);
        }

    }

    public  void jump(Class<?> cls,boolean isFinish){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        if(isFinish){
            this.finish();
        }
    }

}
