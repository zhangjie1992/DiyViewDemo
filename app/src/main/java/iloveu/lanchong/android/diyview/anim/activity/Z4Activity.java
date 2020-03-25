package iloveu.lanchong.android.diyview.anim.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import iloveu.lanchong.android.diyview.R;
import iloveu.lanchong.android.diyview.sample.activity.InfoActivity;

public class Z4Activity extends AppCompatActivity {

    private View mAnimView;
    private Animator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z4);

        mAnimView = findViewById(R.id.animView);
    }

    public void showInfo(View view){
        String info = getResources().getString(R.string.Z4AnimatorSetInfo);
        InfoActivity.show(this,info);
    }


    /**
     * AnimatorSet练习s
     * Builder练习
     * 执行顺序
     * 注意animatorSet会覆盖ObjectAnimator自己设置的部分属性，见info
     *
     */
    public void animatorSet(View view) {
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffff00, 0xff0000ff);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mAnimView, propertyValuesHolder);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setDuration(1000);

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(mAnimView, "scaleX", 1, 2);
        scaleXAnimator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();


//        //按顺序执行
//        animatorSet.playSequentially(objectAnimator,scaleXAnimator);
//        //一起执行
//        animatorSet.playTogether(objectAnimator,scaleXAnimator);

        //Builder方式
        //执行objectAnimator 停顿2s 执行scaleXAnimator
        animatorSet.play(scaleXAnimator).after(objectAnimator).after(2000);
//        //一起执行
//        animatorSet.play(objectAnimator).with(scaleXAnimator);

        animatorSet.start();
    }


    /**
     * xml实现
     */
    public void xml(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_z4);
        animator.setTarget(mAnimView);
        animator.start();
    }

    private boolean menuIsShow = false;


    public void menuClick(View view) {
        //menu1的动画
        View btn_menu1 = findViewById(R.id.btn_menu1);
        Keyframe keyframeTranslate1 = Keyframe.ofFloat(0, -200);
        Keyframe keyframeTranslate2 = Keyframe.ofFloat(1, -300);
        Keyframe keyframeAlpha1 = Keyframe.ofFloat(0, 0.1f);
        Keyframe keyframeAlpha2 = Keyframe.ofFloat(0, 1f);
        PropertyValuesHolder pvhTranslate = PropertyValuesHolder.ofKeyframe("TranslationY", keyframeTranslate1, keyframeTranslate2);
        PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofKeyframe("alpha", keyframeAlpha1, keyframeAlpha2);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(btn_menu1, pvhTranslate);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(btn_menu1, pvhAlpha);

        //menu2的动画
        View btn_menu3 = findViewById(R.id.btn_menu3);
        PropertyValuesHolder pvhTranslate2 = PropertyValuesHolder.ofKeyframe("TranslationX", keyframeTranslate1, keyframeTranslate2);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(btn_menu3, pvhTranslate2);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(btn_menu3, pvhAlpha);


        //menu3的动画
        View btn_menu2 = findViewById(R.id.btn_menu2);
        Keyframe keyframeTranslate3 = Keyframe.ofFloat(0, -100);
        Keyframe keyframeTranslate4 = Keyframe.ofFloat(1, -150);
        PropertyValuesHolder pvhTranslate3 = PropertyValuesHolder.ofKeyframe("TranslationX", keyframeTranslate3, keyframeTranslate4);
        PropertyValuesHolder pvhTranslate4 = PropertyValuesHolder.ofKeyframe("TranslationY", keyframeTranslate3, keyframeTranslate4);
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofPropertyValuesHolder(btn_menu2, pvhTranslate3);
        ObjectAnimator objectAnimator6 = ObjectAnimator.ofPropertyValuesHolder(btn_menu2, pvhTranslate4);
        ObjectAnimator objectAnimator7 = ObjectAnimator.ofPropertyValuesHolder(btn_menu2, pvhAlpha);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3,objectAnimator4,objectAnimator5,objectAnimator6,objectAnimator7);
        animatorSet.setDuration(500);
        animatorSet.start();




    }

    public void menuClick1(View view) {
    }
    public void menuClick2(View view) {
    }
    public void menuClick3(View view) {
    }
}
