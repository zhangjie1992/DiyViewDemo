package iloveu.lanchong.android.diyview.unspecified.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import iloveu.lanchong.android.diyview.BaseActivity;
import iloveu.lanchong.android.diyview.R;

/**
 * 属性的学习
 * 1.通过设置window的宽高，来修改Activity和dialog的展示样式
 * 2.获取屏幕宽高可能常见的错误
 * 3.dilog要怎么占满全屏
 */
public class WindowLayoutParamsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setWindowSizeHalfScreen(getWindow());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_layout_params);
    }


    @Override
    public int getInfo() {
        return R.string.WindowLayoutParamsInfo;
    }


    /**
     * dialog设置为占满屏幕
     */
    public void showDialog(View view){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_window_layout_params);

        Window window = dialog.getWindow();
        //设置占满全屏
        setWindowSizeFullScreen(window);
        //dialog的decorView自带padding
        window.getDecorView().setPadding(0,0,0,0);
        //通过设置bg，可以很好的看到padding。当然Layout Inspector是最好的工具
        window.getDecorView().setBackgroundColor(Color.RED);

        dialog.show();
    }

    /**
     * 占满全屏
     * @param window
     */
    private void setWindowSizeFullScreen(Window window) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager m = window.getWindowManager();
        //将虚拟按键的高度忽略
//        m.getDefaultDisplay().getMetrics(dm);
        //真实的屏幕的高度
        m.getDefaultDisplay().getRealMetrics(dm);
        // 为获取屏幕宽、高
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = dm.heightPixels; //高度设置为屏幕的1
        p.width = dm.widthPixels; // 宽度设置为屏幕的1
//        p.alpha = 1.0f; // 设置本身透明度
//        p.dimAmount = 0.6f; // 设置黑暗度
        window.setAttributes(p);
    }

    /**
     * 占满全屏
     * @param window
     */
    private void setWindowSizeFullScreen2(Window window) {
        // 为获取屏幕宽、高
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = WindowManager.LayoutParams.MATCH_PARENT;
        p.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(p);
    }

    /**
     * 一般屏幕
     * @param window
     */
    private void setWindowSizeHalfScreen(Window window) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager m = window.getWindowManager();
        m.getDefaultDisplay().getRealMetrics(dm);
        // 为获取屏幕宽、高
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = dm.heightPixels/2; //高度设置为屏幕的1
        p.width = dm.widthPixels/2; // 宽度设置为屏幕的1
        window.setAttributes(p);
    }




}
