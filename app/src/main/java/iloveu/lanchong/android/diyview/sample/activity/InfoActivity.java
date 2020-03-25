package iloveu.lanchong.android.diyview.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import iloveu.lanchong.android.diyview.R;

public class InfoActivity extends AppCompatActivity {

    public static void show(Context context,String info){
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra("info",info);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView tv = (TextView)findViewById(R.id.tv);
        String info = getIntent().getStringExtra("info");
        if (!TextUtils.isEmpty(info)){
            tv.setText(info);
        }else {
            Toast.makeText(this,"没有需要展示的内容",Toast.LENGTH_SHORT);
        }
    }



}
