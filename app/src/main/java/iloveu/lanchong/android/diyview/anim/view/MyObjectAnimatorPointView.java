package iloveu.lanchong.android.diyview.anim.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import iloveu.lanchong.android.diyview.App;


public class MyObjectAnimatorPointView extends View {

    private Point curPoint;
    private Paint paint;
    private int mCx;


    public MyObjectAnimatorPointView(Context context) {
        this(context, null);
    }

    public MyObjectAnimatorPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyObjectAnimatorPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        curPoint = new Point();
        curPoint.setRedius(App.dip2px(20));

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        //这个100是圆心的偏移量,由布局宽高200dp决定的
        mCx = App.dip2px(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (curPoint != null) {
            canvas.drawCircle(mCx, mCx, curPoint.getRedius(), paint);
        }
    }

    public void setRedius(int redius) {
        curPoint.setRedius(redius);
        invalidate();
    }

    public class Point {
        //圆半径
        private int redius;

        public int getRedius() {
            return redius;
        }

        public void setRedius(int redius) {
            this.redius = redius;
        }
    }


}
