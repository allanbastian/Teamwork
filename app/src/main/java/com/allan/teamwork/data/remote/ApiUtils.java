package com.allan.teamwork.data.remote;

import

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/photos";

    public static ApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
