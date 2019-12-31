package com.bawei.liruilong.model;

import com.bawei.liruilong.contract.IHomeContract;
import com.bawei.liruilong.model.bean.Bean;
import com.bawei.liruilong.util.NetUtil;
import com.google.gson.Gson;

/**
 * Time:2019/12/31
 * Author:天祈Aa
 * Description:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(IModelCallBack iModelCallBack) {
        String httpUrl="http://blog.zhaoliang5156.cn/api/news/ranking.json";
        NetUtil.getInstance().getJsonGet(httpUrl, new NetUtil.MyCallBack() {
            @Override
            public void onJson(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallBack.onHomeSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onHomeFailure(throwable);
            }
        });
    }
}
