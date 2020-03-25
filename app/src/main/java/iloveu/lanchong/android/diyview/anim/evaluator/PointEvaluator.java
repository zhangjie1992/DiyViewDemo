package iloveu.lanchong.android.diyview.anim.evaluator;

import android.animation.TypeEvaluator;
import android.util.Log;

import iloveu.lanchong.android.diyview.anim.view.AnimationPointView;

public class PointEvaluator implements TypeEvaluator<AnimationPointView.Point> {

    @Override
    public AnimationPointView.Point evaluate(float fraction, AnimationPointView.Point startValue, AnimationPointView.Point endValue) {
        int intStart = startValue.getRedius();
        int intEnd = endValue.getRedius();

        startValue.setRedius((int) (intStart + fraction * (intEnd - intStart)));
        Log.e("PointEvaluator",startValue.getRedius()+"  "+fraction);
        return startValue;
    }
}
