package iloveu.lanchong.android.diyview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CycleView extends View {

    Paint paint;
    int width = 100;
    int height = 100;


    public CycleView(Context context) {
        this(context,null);
    }

    public CycleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CycleView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //使用离屏绘制
        int layerID = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(createDstBigmap(width, height), 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(createSrcBigmap(width, height), 0, 0, paint);
        paint.setXfermode(null);

        canvas.restoreToCount(layerID);

    }

    /**
     * 圆
     * @param width
     * @param height
     * @return
     */
    public Bitmap createDstBigmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint scrPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        scrPaint.setColor(0xFFFFCC44);
        canvas.drawCircle(width / 2, height / 2, width / 2, scrPaint);
        return bitmap;
    }

    /**
     * 方
     * @param width
     * @param height
     * @return
     */
    public Bitmap createSrcBigmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint dstPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dstPaint.setColor(0xFF000000);
        canvas.drawRect(new Rect(0, 0, width, height), dstPaint);
        return bitmap;
    }























}
