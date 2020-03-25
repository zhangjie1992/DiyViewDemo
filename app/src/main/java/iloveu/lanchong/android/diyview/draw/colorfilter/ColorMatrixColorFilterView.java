package iloveu.lanchong.android.diyview.draw.colorfilter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆DST，方SRC
 */
public class ColorMatrixColorFilterView extends View {
    int width = 100;
    int height = 100;
    private Paint mPaint;
    private ColorMatrixColorFilter mColorMatrixColorFilter;

    public ColorMatrixColorFilterView(Context context) {
        this(context, null);
    }

    public ColorMatrixColorFilterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorMatrixColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                -1, 0,    0,    0, 255,  // 红色向量
                0,    -1, 0,    0, 255,  // 绿色向量
                0,    0,    -1, 0, 255,  // 蓝色向量
                0,    0,    0,    -1, 0   // 透明度向量
        });
        mColorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mPaint.setColorFilter(mColorMatrixColorFilter);

        // 设置画笔颜色为自定义颜色
        mPaint.setColor(Color.argb(255, 0, 0, 0));

        // 绘制圆环 (x坐标，y坐标，半径，画笔)
        canvas.drawCircle(width/2, height/2, width/2, mPaint);

    }



















}
