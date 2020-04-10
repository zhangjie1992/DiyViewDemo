package iloveu.lanchong.android.diyview.unspecified.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import iloveu.lanchong.android.diyview.R;


/**
 * android坐标系-视图坐标系
 *
 * 结论：View的getX，getY，getLeft，getTop...都是基于视图坐标系，也就是父控件
 *
 */
public class AndroidViewCoordinateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_coordinate);
    }

    public void lefttop(View v) {
        float x = v.getX();
        float y = v.getY();

        int left = v.getLeft();
        int top = v.getTop();
        Log.e("zjzjzj", "x:" + x + " y:" + y + " left:" + left + " top:" + top);

    }

    public void righttop(View v) {
        float x = v.getX();
        float y = v.getY();

        int left = v.getLeft();
        int top = v.getTop();
        Log.e("zjzjzj", "x:" + x + " y:" + y + " left:" + left + " top:" + top);
    }

    public void rightbottom(View v) {
        float x = v.getX();
        float y = v.getY();

        int left = v.getLeft();
        int top = v.getTop();
        Log.e("zjzjzj", "x:" + x + " y:" + y + " left:" + left + " top:" + top);
    }

    public void fltv(View v) {
        float x = v.getX();
        float y = v.getY();

        int left = v.getLeft();
        int top = v.getTop();
        //0 0 0 0
        Log.e("zjzjzj", "x:" + x + " y:" + y + " left:" + left + " top:" + top);

        v.setX(40);
    }


}
