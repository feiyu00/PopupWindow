package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popupwindow.util.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPop;
    private PopupWindow mPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView = view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击之后pop消失
                        mPop.dismiss();
                        //
                        ToastUtil.showMsg(MainActivity.this,"好");
                    }
                });
                mPop = new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                //点击空白消失
                mPop.setOutsideTouchable(true);
                //点击收起，再点击弹出
                mPop.setFocusable(true);
                //动画效果
//                mPop.setAnimationStyle();
                mPop.showAsDropDown(mBtnPop);
            }
        });
    }
}
