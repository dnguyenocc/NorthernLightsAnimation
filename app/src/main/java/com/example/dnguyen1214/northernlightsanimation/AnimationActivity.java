package com.example.dnguyen1214.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;

    private AnimationDrawable frameAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View view){
        // 1. Programmatically set the background of the image view to @drawable/lights1
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);

        // 2. Associate the frameAnim with the animation in XML
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();

        // 3. Start the frame animation
        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();

    }

    public void toggleRotateAnim(View view)
    {
        if (rotateAnim!=null && rotateAnim.hasStarted()){
            lightsImageView.clearAnimation();
            rotateAnim=null;
        }
        else
        {
            rotateAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void toggleShakeAnim(View view)
    {
        shakeAnim = AnimationUtils.loadAnimation(this,R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);

    }

    public void toggleFlipAnim(View view)
    {
        if (customAnim!=null && customAnim.hasStarted()){
            lightsImageView.clearAnimation();
            customAnim=null;
        }
        else
        {
            customAnim = AnimationUtils.loadAnimation(this,R.anim.custom_anim);
            lightsImageView.startAnimation(customAnim);
        }
    }
}
