package com.example.android.tesis.network;

import com.example.android.tesis.my_interface.APIService;

/**
 * Created by rjsan on 7/19/2018.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.1.3:8080/";

    public static APIService getAPIService(){
        return RetrofitInstance.getRetrofitInstance(BASE_URL).create(APIService.class);
    }

}
