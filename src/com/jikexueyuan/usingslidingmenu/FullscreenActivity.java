package com.jikexueyuan.usingslidingmenu;

import com.jikexueyuan.usingslidingmenu.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;




public class FullscreenActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = View.inflate(this, R.layout.activity_fullscreen, null);
        setContentView(view);
                                                                      
        //渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        aa.setAnimationListener(new AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationStart(Animation animation) {}
                                                                          
        });
                                                                      
                                                          
    }
                                                                  
    /**
     * 跳转到...
     */
    private void redirectTo(){       
        Intent intent3 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
