package iloveu.lanchong.android.diyview.anim.activity;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import iloveu.lanchong.android.diyview.R;
import iloveu.lanchong.android.diyview.sample.activity.InfoActivity;
import iloveu.lanchong.android.diyview.anim.evaluator.CharEvaluator;
import iloveu.lanchong.android.diyview.anim.interpolator.MyInterpolator;
import iloveu.lanchong.android.diyview.anim.view.AnimationPointView;

public class Z2Activity extends AppCompatActivity {

    private View mAnimView;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z2);

        mAnimView = findViewById(R.id.animView);
    }


    public void showInfo(View view){
        String info = getResources().getString(R.string.Z2AnimatorInfo);
        InfoActivity.show(this,info);
    }


    public void valueAnimatorAlpha(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0.1f);
        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mAnimView.setAlpha(animatedValue);
            }
        });
        valueAnimator.start();
    }


    /**
     * ValueAnimator.ofInt(0, 400,0,200);
     */
    public void valueAnimatorLayout(View view) {
        valueAnimator = ValueAnimator.ofInt(0, 400,0,200);
        valueAnimator.setDuration(5000);

        final int left = mAnimView.getLeft();
        final int top = mAnimView.getTop();
        final int width = mAnimView.getWidth();
        final int height = mAnimView.getHeight();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mAnimView.layout(left+animatedValue,top+animatedValue,left+animatedValue+width,top+animatedValue+height);

            }
        });
        valueAnimator.start();
    }

    /**
     * 位移加Interpolator
     */
    public void valueAnimatorInterpolator(View view) {
        valueAnimator = ValueAnimator.ofInt(0, 600);
        valueAnimator.setDuration(500);

        final int left = mAnimView.getLeft();
        final int top = mAnimView.getTop();
        final int width = mAnimView.getWidth();
        final int height = mAnimView.getHeight();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mAnimView.layout(left,top+animatedValue,left+width,top+animatedValue+height);

            }
        });
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }

    /**
     * 自定义Interpolator
     */
    public void myInterpolator(View view) {
        valueAnimator = ValueAnimator.ofInt(0, 600);
        valueAnimator.setDuration(500);

        final int left = mAnimView.getLeft();
        final int top = mAnimView.getTop();
        final int width = mAnimView.getWidth();
        final int height = mAnimView.getHeight();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mAnimView.layout(left,top+animatedValue,left+width,top+animatedValue+height);

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            valueAnimator.setInterpolator(new MyInterpolator());
        }
//        valueAnimator.setEvaluator(new FloatEvaluator());
        valueAnimator.start();
    }

    /**
     * argbEvaluator的使用，计算颜色的变化
     */
    public void argbEvaluator(View view) {
        valueAnimator = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mAnimView.setBackgroundColor(animatedValue);

            }
        });
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.start();
    }


    /**
     * {@link ValueAnimator#ofObject(TypeEvaluator, Object...)}
     * 需要传入自定义Evaluator
     */
    public void myEvaluator(View view) {
        final TextView mAnimView = findViewById(R.id.animCharView);

        valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),'a','z','a');
        valueAnimator.setDuration(20000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Character animatedValue = (Character) animation.getAnimatedValue();
                mAnimView.setText(String.valueOf(animatedValue));
            }
        });
        valueAnimator.start();
    }

    /**
     * 自定义MyPointView及动画
     */
    public void myPointView(View view) {
        final AnimationPointView mAnimView = findViewById(R.id.myPointView);
        mAnimView.doPointAnim();
    }


    /**
     * 清除动画
     */
    public void animCancel(View view) {
        valueAnimator.cancel();
//        valueAnimator.end();
    }



}
