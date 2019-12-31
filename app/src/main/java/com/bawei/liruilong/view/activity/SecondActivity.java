package com.bawei.liruilong.view.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.liruilong.R;
import com.bawei.liruilong.base.BaseActivity;
import com.bawei.liruilong.base.BasePresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {
//找控件
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.b1)
    Button b1;
    @BindView(R.id.b2)
    Button b2;

    @Override
    protected void initData() {
        //绑定
        ButterKnife.bind(this);
        CodeUtils.init(this);

        String name="李瑞龙";
        String trim = name.trim();
        if (!TextUtils.isEmpty(trim)){
            Bitmap image = CodeUtils.createImage(trim, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            iv.setImageBitmap(image);
        }

        CodeUtils.analyzeByImageView(iv, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(SecondActivity.this, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(SecondActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }

    @OnClick({R.id.b1, R.id.b2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.b1:
                EventBus.getDefault().postSticky("微信");
                break;
            case R.id.b2:
                EventBus.getDefault().postSticky("QQ");
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // TODO: 2019/12/31 注册
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // TODO: 2019/12/31 解绑
        EventBus.getDefault().unregister(this);
    }

    // TODO: 2019/12/31 订阅
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getWX(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    // TODO: 2019/12/31 订阅
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getQQ(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
