package iloveu.lanchong.android.diyview.anim.activity;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;

import iloveu.lanchong.android.diyview.App;
import iloveu.lanchong.android.diyview.BaseActivity;
import iloveu.lanchong.android.diyview.R;
import iloveu.lanchong.android.diyview.anim.view.MyObjectAnimatorPointView;
import iloveu.lanchong.android.diyview.sample.activity.InfoActivity;

public class Z3Activity extends BaseActivity {

    private View mAnimView;
    private Animator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z3);

        mAnimView = findViewById(R.id.animView);
    }

    @Override
    public int getInfo() {
        return R.string.Z3AnimatorInfo;
    }

    /**
     * ObjectAnimator的实现
     */
    public void myPointView(View view) {
        MyObjectAnimatorPointView myObjectAnimatorPointView = findViewById(R.id.myPointView);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(myObjectAnimatorPointView, "redius", App.dip2px(20), App.dip2px(100));
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }


    /**
     * PropertyValuesHolder的使用
     */
    public void propertyValuesHolder(View view) {
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffff00, 0xff0000ff);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mAnimView, propertyValuesHolder);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }


    /**
     * ##最完美的写法##
     * 通过关键帧来做复杂动画
     */
    public void keyframe(View view) {
        Keyframe keyframe = Keyframe.ofFloat(0, 1);
        Keyframe keyframe1 = keyframe.ofFloat(0.5f, 2);
        Keyframe keyframe2 = Keyframe.ofFloat(1, 1);

        keyframe1.setInterpolator(new OvershootInterpolator());
        keyframe2.setInterpolator(new BounceInterpolator());

        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("scaleX", keyframe, keyframe1, keyframe2);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mAnimView, propertyValuesHolder);

        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofKeyframe("scaleY", keyframe, keyframe1, keyframe2);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mAnimView, propertyValuesHolder,propertyValuesHolder2);

        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }



}
