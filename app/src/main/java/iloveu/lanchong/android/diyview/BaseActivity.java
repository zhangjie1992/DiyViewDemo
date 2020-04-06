package iloveu.lanchong.android.diyview;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import iloveu.lanchong.android.diyview.sample.activity.InfoActivity;

public abstract class BaseActivity extends AppCompatActivity {



    public void showInfo(View view){
        String info = getResources().getString(getInfo());
        InfoActivity.show(this,info);
    }


    public abstract  @StringRes int getInfo();


}
