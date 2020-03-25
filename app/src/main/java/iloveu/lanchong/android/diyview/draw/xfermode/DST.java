package iloveu.lanchong.android.diyview.draw.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆DST，方SRC
 */
public class DST extends View {
    int width = 100;
    int height = 100;
    private Paint mPaint;
    private PorterDuffXfermode mPorterDuffXfermode;

    public DST(Context context) {
        this(context, null);
    }

    public DST(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DST(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        Bitmap dst = createDst();
        canvas.drawBitmap(dst, 0, 0, mPaint);

        mPaint.setXfermode(mPorterDuffXfermode);
        Bitmap src = createSrc();
        canvas.drawBitmap(src, width / 2, height / 2, mPaint);

        mPaint.setXfermode(null);
    }

    /**
     * 圆DST
     */
    private Bitmap createDst() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(width / 2, height / 2, width / 2, paint);
        return bitmap;
    }

    /**
     * 方SRC
     */
    private Bitmap createSrc() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, width, height, paint);
        return bitmap;
    }
}
