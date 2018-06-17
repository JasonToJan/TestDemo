package com.xingfu.testdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xingfu.library1.Library1Activity;
import com.xingfu.library1.PrePareActivity;
import com.xingfu.library2.Library2Activity;
import com.xingfu.library2.ToastUtils;
import com.xingfu.library3.DisplayUtils;
import com.xingfu.library3.Library3Activity;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn1=findViewById(R.id.at_test1_btn);
        btn2=findViewById(R.id.at_test2_btn);
        btn3=findViewById(R.id.at_test3_btn);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.at_test1_btn:
                ToastUtils.getInstanc(this).showToast("点击了按钮1,即将调整到活动1,同时使用了了库1中的类返回值为：");
                Intent intent1 = new Intent(android.content.Intent.ACTION_VIEW);
                intent1.setComponent(new ComponentName("com.xingfu.testdemo","com.xingfu.library1.Library1Activity"));
                startActivity(intent1);
              /* Intent intent1=new Intent(this, Library1Activity.class);
               startActivity(intent1);*/
                break;
            case R.id.at_test2_btn:
                ToastUtils.getInstanc(this).showToast("点击了按钮2,即将调整到活动2");
                Intent intent2 = new Intent(this, Library2Activity.class);
                startActivity(intent2);
               /* Intent intent2 = new Intent(android.content.Intent.ACTION_VIEW);
                intent2.setComponent(new ComponentName("com.xingfu.testdemo","com.xingfu.library2.Library2Activity"));
                startActivity(intent2);*/
                break;
            case R.id.at_test3_btn:
                /*ToastUtils.getInstanc(this).showToast("点击了按钮3,即将调整到活动3，同时使用了库3中的类返回值为："
                        + DisplayUtils.dip2px(this,10));
                Intent intent3 = new Intent(this, Library3Activity.class);
                startActivity(intent3);*/
                Intent intent3=new Intent(this, PrePareActivity.class);
                startActivity(intent3);

                /*Intent intent3 = new Intent(android.content.Intent.ACTION_VIEW);
                intent3.setComponent(new ComponentName("com.xingfu.testdemo","com.xingfu.library3.Library3Activity"));
                startActivity(intent3);*/
                break;
        }
    }
}
