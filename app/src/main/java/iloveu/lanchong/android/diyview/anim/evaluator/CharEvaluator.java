package iloveu.lanchong.android.diyview.anim.evaluator;

import android.animation.TypeEvaluator;

/**
 * 字符转换计算器
 */
public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {

        int intStart = startValue;
        int intEnd = endValue;

        char v = (char) (intStart + fraction * (intEnd - intStart));
        return v;
    }


}
