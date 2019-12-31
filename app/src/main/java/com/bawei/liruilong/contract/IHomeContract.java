package com.bawei.liruilong.contract;

import com.bawei.liruilong.model.bean.Bean;

/**
 * Time:2019/12/31
 * Author:天祈Aa
 * Description:
 */
public interface IHomeContract {
    //V层
    interface IView{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);
    }
    //P层
    interface IPresenter{
        void getHomeData();
    }
    //M层
    interface IModel{
        void getHomeData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);
        }
    }


}
