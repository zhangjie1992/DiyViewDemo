package iloveu.lanchong.android.diyview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CycleView3 extends View {

    int width = 100;
    int height = 100;

    public CycleView3(Context context) {
        this(context,null);
    }

    public CycleView3(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CycleView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

    }

    /**
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

//        Paint paint = new Paint();
//        paint.setColor(0xff000000);
//        canvas.drawRect(new Rect(0,0,width,height),paint);
//
//        canvas.translate(50,50);
//
//
        Paint paint2 = new Paint();
        paint2.setColor(0xffff0000);
//        canvas.drawRect(new Rect(0,0,width,height),paint2);


        Bitmap bitmap = Bitmap.createBitmap(width/2, height, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColor(0xff000000);
        Canvas canvas1 = new Canvas(bitmap);
        canvas1.drawOval(new RectF(0,0,width,height),paint);

        canvas.drawBitmap(bitmap,0,0,paint2);

    }
























}
