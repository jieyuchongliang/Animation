package diancan.fujisoft.com.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStop;
    private AnimationDrawable anim, animBg, animTvBg, animPageLoading;
    private ImageView iv, ivPageLoading, ivDanruDanchu,ivLoading;
    private TextView textView;
    private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        ivPageLoading = (ImageView) findViewById(R.id.iv_page_loading);
        btnStop = (Button) findViewById(R.id.btn_stop);
        textView = (TextView) findViewById(R.id.tv);
        ivDanruDanchu = (ImageView) findViewById(R.id.iv_danru_danchu);
        ivLoading = (ImageView) findViewById(R.id.iv_loading);
        btnStop.setOnClickListener(this);


        anim = (AnimationDrawable) iv.getDrawable();
        animBg = (AnimationDrawable) iv.getBackground();
        animTvBg = (AnimationDrawable) textView.getBackground();
        animPageLoading = (AnimationDrawable) ivPageLoading.getDrawable();
        AnimationDrawable animIvLoading = (AnimationDrawable) ivLoading.getDrawable();


        animTvBg.start();
        animBg.start();
        anim.start();
        animPageLoading.start();
        animIvLoading.start();

        attributeAnimation();
//        attributeAnimationDanruDanchu();
        allAnimation();
    }

    private void allAnimation() {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        alphaAnim.setRepeatCount(100);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "scaleX", 0.0f, 1.0f);
        scaleXAnim.setRepeatCount(100);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "scaleY", 0.0f, 2.0f);
        scaleYAnim.setRepeatCount(100);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "rotation", 0, 360);
        rotateAnim.setRepeatCount(100);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "translationX", 100, 400);
        transXAnim.setRepeatCount(100);
        ObjectAnimator transYAnim = ObjectAnimator.ofFloat(ivDanruDanchu, "translationY", 100, 750);
        transYAnim.setRepeatCount(100);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
//        set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
        set.setDuration(3000);
        set.start();
    }

    /**
     * 淡入淡出属性动画
     */
    private void attributeAnimationDanruDanchu() {
        ObjectAnimator danruDanchuAnimator = ObjectAnimator.ofFloat(ivDanruDanchu, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0);
        danruDanchuAnimator.setRepeatCount(100);
        danruDanchuAnimator.setDuration(2000);
        danruDanchuAnimator.setRepeatMode(ValueAnimator.REVERSE);
        danruDanchuAnimator.start();
    }

    /**
     * 旋转属性动画
     */
    private void attributeAnimation() {
        animator = ObjectAnimator.ofFloat(btnStop, "rotation", 0f, 360f);
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_stop:
                if (animator.isStarted()) {
                    animator.end();
                } else {
                    animator.start();
                }
                break;
            default:
                break;
        }
    }
}
