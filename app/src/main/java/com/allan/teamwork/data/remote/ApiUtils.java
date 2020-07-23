package com.allan.teamwork.data.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static ApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
