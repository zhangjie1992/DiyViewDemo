package iloveu.lanchong.android.diyview.draw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import iloveu.lanchong.android.diyview.R;
import iloveu.lanchong.android.diyview.draw.view.DiyTest1View1;

public class DiyTest1Activity extends AppCompatActivity {

    private ViewGroup mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_test1);
        mContainer = findViewById(R.id.constraintLayout);
    }

    private void removeAllChild() {
        for (int i =0;i<mContainer.getChildCount();i++){
            View childAt = mContainer.getChildAt(0);
            if (childAt instanceof Button){

            } else {
                mContainer.removeView(childAt);
            }
        }
//        String s = "fff";
//        s.substring(0,s.length()-i);
    }


    public void addView1(View view) {
        removeAllChild();
        DiyTest1View1 diyTest1View1 = new DiyTest1View1(this);
        mContainer.addView(diyTest1View1);

    }



    public void addView2(View view) {
        removeAllChild();
        DiyTest1View1 diyTest1View1 = new DiyTest1View1(this);
        mContainer.addView(diyTest1View1);
    }
}
