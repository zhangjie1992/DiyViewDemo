package iloveu.lanchong.android.diyview.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

//设置阴影
public class DiyTest1View2 extends View {

    private Paint mPaint;

    public DiyTest1View2(Context context) {
        super(context);
        init();
    }

    public DiyTest1View2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiyTest1View2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        //描边
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShadowLayer(15,10,10,Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText("i love u",0,0,mPaint);
    }

}
