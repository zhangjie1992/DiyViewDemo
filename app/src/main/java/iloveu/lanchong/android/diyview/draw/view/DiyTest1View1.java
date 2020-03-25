package iloveu.lanchong.android.diyview.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import iloveu.lanchong.android.diyview.App;

public class DiyTest1View1 extends View {

    private Paint mPaint;
    private int mCx;

    public DiyTest1View1(Context context) {
        super(context);
        init();
    }

    public DiyTest1View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiyTest1View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        //描边
        mPaint.setStyle(Paint.Style.STROKE);

        //这个100是圆心的偏移量,由布局宽高200dp决定的
        mCx = App.dip2px(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(mCx,mCx,mCx,mPaint);


//        画布背景设置：
//        canvas.drawColor(Color.BLUE);
//        canvas.drawRGB(255, 255, 0);   //这两个功能一样，都是用来设置背景颜色的。

    }
}
