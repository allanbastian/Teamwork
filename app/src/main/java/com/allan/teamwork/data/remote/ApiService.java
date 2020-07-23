package com.allan.teamwork.data.remote;

import com.allan.teamwork.data.models.PhotoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("photos")
    Call<PhotoResponse> getPhotos();
}
