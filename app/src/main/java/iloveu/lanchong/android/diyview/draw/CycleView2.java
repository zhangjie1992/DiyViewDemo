package iloveu.lanchong.android.diyview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CycleView2 extends View {

    Paint paint;
    int width = 100;
    int height = 100;

    public CycleView2(Context context) {
        this(context,null);
    }

    public CycleView2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CycleView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //初始化画笔
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    /**
     * canvas.drawBitmap(createSrcBigmap(width, height), width / 2, height / 2, paint);
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        Bitmap bitmapDST = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvasDST = new Canvas(bitmapDST);
        canvasDST.drawCircle(width/2,height/2,width/2,paint);

//        Bitmap dstBigmap = createDstBigmap(width, height);

        Bitmap srcBigmap = createSrcBigmap(width, height);


        canvas.drawBitmap(srcBigmap,0,0,paint);


//        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.ADD);
//        paint.setXfermode(porterDuffXfermode);
//
//        canvas.drawCircle();

    }



    public Bitmap createDstBigmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint scrPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        scrPaint.setColor(0xFFFFCC44);
        canvas.drawCircle(width / 2, height / 2, width / 2, scrPaint);
        return bitmap;
    }


    public Bitmap createSrcBigmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(0xff000000);
        Rect rect = new Rect(0,0,width,height);
        canvas.drawRect(rect,paint);
        return bitmap;
    }





















}
