package iloveu.lanchong.android.diyview.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import iloveu.lanchong.android.diyview.R;
import iloveu.lanchong.android.diyview.activity.DiyTest1Activity;
import iloveu.lanchong.android.diyview.anim.activity.Z1Activity;
import iloveu.lanchong.android.diyview.anim.activity.Z2Activity;
import iloveu.lanchong.android.diyview.anim.activity.Z3Activity;
import iloveu.lanchong.android.diyview.anim.activity.Z4Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showInfo(View view){
        String info = getResources().getString(R.string.info);
        InfoActivity.show(this,info);
    }


    public void animation(View view){
        Intent intent = new Intent(this, Z1Activity.class);
        startActivity(intent);
    }

    public void animator(View view) {
        Intent intent = new Intent(this, Z2Activity.class);
        startActivity(intent);
    }

    public void objectanimator(View view) {
        Intent intent = new Intent(this, Z3Activity.class);
        startActivity(intent);
    }

    public void AnimatorSet(View view) {
        Intent intent = new Intent(this, Z4Activity.class);
        startActivity(intent);
    }

    public void test1(View view) {
        Intent intent = new Intent(this, DiyTest1Activity.class);
        startActivity(intent);
    }



}
