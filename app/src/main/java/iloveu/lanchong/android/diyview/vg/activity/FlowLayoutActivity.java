package iloveu.lanchong.android.diyview.vg.activity;

import android.os.Bundle;

import iloveu.lanchong.android.diyview.BaseActivity;
import iloveu.lanchong.android.diyview.R;

/**
 *
 * 自定义流式布局
 * 流式布局最后一个子控件的width超过父控件
 *
 */
public class FlowLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
    }

    @Override
    public int getInfo() {
        return 0;
    }

}
