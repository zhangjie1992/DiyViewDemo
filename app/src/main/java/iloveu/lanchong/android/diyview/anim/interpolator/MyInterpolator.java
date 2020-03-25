package iloveu.lanchong.android.diyview.anim.interpolator;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.BaseInterpolator;

/**
 * 倒序匀速显示
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
public class MyInterpolator extends BaseInterpolator  {

    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }

}
