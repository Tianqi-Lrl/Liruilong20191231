package com.bawei.liruilong.presenter;

import com.bawei.liruilong.base.BasePresenter;
import com.bawei.liruilong.contract.IHomeContract;
import com.bawei.liruilong.model.HomeModel;
import com.bawei.liruilong.model.bean.Bean;

/**
 * Time:2019/12/31
 * Author:天祈Aa
 * Description:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomeContract.IModel.IModelCallBack() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);
            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);
            }
        });
    }
}
