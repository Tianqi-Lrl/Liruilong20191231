package com.bawei.liruilong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liruilong.R;
import com.bawei.liruilong.base.BaseActivity;
import com.bawei.liruilong.contract.IHomeContract;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.presenter.HomePresenter;
import com.bawei.liruilong.view.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 *@date:2019/12/31
 *@author:天祈
 *@description
 */
public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {

    //找控件
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void initData() {
        //绑定
        ButterKnife.bind(this);
        mPresenter.getHomeData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomeSuccess(Bean bean) {
        List<Bean.RankingBean> ranking = bean.getRanking();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置布局
        rv.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(ranking);
        //设置适配器
        rv.setAdapter(myAdapter);
    }

    @Override
    public void onHomeFailure(Throwable throwable) {
        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        //点击跳转
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
