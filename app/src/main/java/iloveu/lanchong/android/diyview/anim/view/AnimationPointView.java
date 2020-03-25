package iloveu.lanchong.android.diyview.anim.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import iloveu.lanchong.android.diyview.App;
import iloveu.lanchong.android.diyview.anim.evaluator.PointEvaluator;


public class AnimationPointView extends View {

    private Point curPoint;
    private Paint paint;
    private int mCx;


    public AnimationPointView(Context context) {
        this(context,null);
    }

    public AnimationPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public AnimationPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        if (curPoint!=null){
            canvas.drawCircle(mCx,mCx,curPoint.getRedius(),paint);
        }
    }

    public void doPointAnim(){
        curPoint.setRedius(App.dip2px(20));

        Point endPoint = new Point();
        endPoint.setRedius(App.dip2px(100));

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),curPoint,endPoint);
        valueAnimator.setDuration(1000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                curPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        //有效果 只是看不出来,可以通过打印日志看出效果
//        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.start();
    }


    public class Point{
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
