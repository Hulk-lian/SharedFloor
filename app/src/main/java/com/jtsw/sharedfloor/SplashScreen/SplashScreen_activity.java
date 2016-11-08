package com.jtsw.sharedfloor.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.Selector_activity;
import com.jtsw.sharedfloor.login.Login_Activity;

public class SplashScreen_activity extends AppCompatActivity {

    private static final int TIME = 4000;
    private static final int DELAY=900;
    private ImageView mImgvLogo,mImgName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_activity);
        Animation animationImg= AnimationUtils.loadAnimation(SplashScreen_activity.this,R.anim.descend_animation);
        Animation animationName= AnimationUtils.loadAnimation(SplashScreen_activity.this,R.anim.descend_animation);
        animationName.setStartOffset(DELAY);

        mImgvLogo=(ImageView)findViewById(R.id.splashIMVimg);
        mImgName=(ImageView)findViewById(R.id.splashIMVname);

        mImgvLogo.setAnimation(animationImg);
        mImgName.setAnimation(animationName);

        new Handler().postDelayed( new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(SplashScreen_activity.this,Login_Activity.class));
                finish();
            }
        },TIME);
    }
}
