package com.example.app.wk_02;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class StatrtActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable javaAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statrt);

        imageView=findViewById(R.id.imageView);

        javaAnimationDrawable=initFrameDrawable();

           javaAnimationDrawable.start();

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent=new Intent(StatrtActivity.this,
                        MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                finish();
            }
        },5000);
    }

    //实例化方法
    private AnimationDrawable initFrameDrawable(){
        javaAnimationDrawable=new AnimationDrawable();
        javaAnimationDrawable.setOneShot(false);
        for (int i=1;i<9;i++){
            Drawable d=null;
            int id=0;
            Resources resources=getResources();
            id=resources.getIdentifier("img_0"+i,
                    "mipmap",
                    getPackageName()
            );
            d=getResources().getDrawable(id,null);
            javaAnimationDrawable.addFrame(d,80);
        }
        imageView.setImageDrawable(javaAnimationDrawable);
        return javaAnimationDrawable;
    }
}
