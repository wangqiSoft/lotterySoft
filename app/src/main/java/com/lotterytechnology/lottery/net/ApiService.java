package com.lotterytechnology.lottery.net;

import com.lotterytechnology.lottery.bean.RequestBean;
import com.lotterytechnology.lottery.bean.ResponseData;
import com.lotterytechnology.lottery.bean.UserBean;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 接口地址
 */

public interface ApiService {

    //登录
    @POST("auth/login")
    Flowable<ResponseData<UserBean>> Login(@Body RequestBean body);

}
