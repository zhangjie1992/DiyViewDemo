package iloveu.lanchong.android.diyview.layout.view;

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
//        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        initParams();
        int totalHeight = 0;

        int currWidthLine = 0;

        int maxWidthLine = 0;
        int maxHeightLine = 0;
        List<View> lineChilds = new ArrayList<>();
        mLines.add(lineChilds);

        int horiPadding = getPaddingLeft() + getPaddingRight();
        int verticalPadding = getPaddingTop() + getPaddingBottom();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //测量孩子

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams layoutParams = child.getLayoutParams();
            lineChilds.add(child);


            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, horiPadding, layoutParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, verticalPadding, layoutParams.height);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);


            int childHeight = child.getMeasuredHeight();
            int childWidth = child.getMeasuredWidth();

            maxHeightLine = Math.max(maxHeightLine, childHeight);


            if (nextLine(widthSize, currWidthLine, childWidth)) {
                totalHeight += maxHeightLine;
                maxHeightLine = 0;

                maxWidthLine = Math.max(maxWidthLine, currWidthLine);
                currWidthLine = 0;

                lineChilds = new ArrayList<>();
                mLines.add(lineChilds);
            } else {
                currWidthLine += childWidth;
            }
        }

        //测量自己
        int measuredWidth = widthMode == MeasureSpec.EXACTLY ? widthSize : maxWidthLine;
        int measuredHeight = heightMode == MeasureSpec.EXACTLY ? heightSize : totalHeight;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private boolean nextLine(int widthSize, int currWidthLine, int childWidth) {
        if (currWidthLine + childWidth >= widthSize) {
            return true;
        }
        return false;
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
