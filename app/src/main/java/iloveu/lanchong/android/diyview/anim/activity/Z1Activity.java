package iloveu.lanchong.android.diyview.anim.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import iloveu.lanchong.android.diyview.BaseActivity;
import iloveu.lanchong.android.diyview.R;


public class Z1Activity extends BaseActivity {


    private View mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z1);

        mAnimView = findViewById(R.id.animView);
    }

    public void animAlpha(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_z1);
        mAnimView.startAnimation(animation);
    }

    public void animScale(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_z1);
        mAnimView.startAnimation(animation);
    }

    public void animRotate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_z1);
        mAnimView.startAnimation(animation);
    }

    public void animTranslate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_z1);
        mAnimView.startAnimation(animation);
    }

    /**
     * Interpolator写在scale中未生效
     */
    public void animSet(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_z1);
        mAnimView.startAnimation(animation);
    }

    /**
     * Interpolator写在AnimationSet中未生效
     */
    public void animNoxml(View view) {

        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0.8f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setInterpolator(new OvershootInterpolator());

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);

        animationSet.setDuration(7000);
        animationSet.setFillAfter(true);
        mAnimView.startAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("animationSet","onAnimationStart:animationSet");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("animationSet","onAnimationEnd:animationSet");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("animationSet","onAnimationRepeat:animationSet");
            }
        });

    }

    /**
     * 清除动画，不能使用{@link Animation#cancel()}方法
     *
     */
    public void animCancel(View view) {
        mAnimView.clearAnimation();
    }



    @Override
    public int getInfo() {
        return R.string.Z1AnimationInfo;
    }

}
