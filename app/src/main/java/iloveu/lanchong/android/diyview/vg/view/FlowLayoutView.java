package iloveu.lanchong.android.diyview.vg.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * 目前展示不对，只显示一行
 */
public class FlowLayoutView extends ViewGroup {

    private final List<List<View>> mLines = new ArrayList<>();


    public FlowLayoutView(Context context) {
        super(context);
    }

    public FlowLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initParams();
        int totalHeight = 0;
        int totalMaxWidth = 0;

        int currLineWidth = 0;
        int currLineMaxHeight = 0;
        List<View> currLineChilds = new ArrayList<>();
        mLines.add(currLineChilds);

        int horiPadding = getPaddingLeft() + getPaddingRight();
        int verticalPadding = getPaddingTop() + getPaddingBottom();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //测量孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams layoutParams = child.getLayoutParams();

            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, horiPadding, layoutParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, verticalPadding, layoutParams.height);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (nextLine(widthSize, currLineWidth, childWidth)) {
                //换行
                //保存旧行的数据
                totalHeight += currLineMaxHeight;
                totalMaxWidth = Math.max(totalMaxWidth, currLineWidth);

                //新行
                currLineChilds = new ArrayList<>();
                mLines.add(currLineChilds);
            }

            //记录数据到当前行
            currLineChilds.add(child);
            currLineWidth += childWidth;
            currLineMaxHeight = Math.max(currLineMaxHeight, childHeight);

            if (i + 1 == childCount) {
                //最后一条数据（如果这里不写，那么数据只有一行时，totalHeight、totalMaxWidth都是0）
                totalHeight += currLineMaxHeight;
                totalMaxWidth = Math.max(totalMaxWidth, currLineWidth);
            }
        }


        //保存测量结果
        int measuredWidth = widthMode == MeasureSpec.EXACTLY ? widthSize : totalMaxWidth;
        int measuredHeight = heightMode == MeasureSpec.EXACTLY ? heightSize : totalHeight;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private boolean nextLine(int widthSize, int widthCurrLine, int childWidth) {
        return widthCurrLine + childWidth >= widthSize;
    }


    private void initParams() {
        mLines.clear();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childRealL = l + getPaddingLeft();
        int childRealT = t + getPaddingTop();
        int currL = childRealL;
        int currT = childRealT;
        for (int i = 0; i < mLines.size(); i++) {
            List<View> views = mLines.get(i);
            int maxHeight = 0;
            for (int j = 0; j < views.size(); j++) {
                View view = views.get(j);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();

                view.layout(currL, currT, currL + measuredWidth, currT + measuredHeight);
                currL += measuredWidth;
                maxHeight = Math.max(maxHeight, measuredHeight);
            }
            currL = childRealL;
            currT += maxHeight;
        }
    }


}
