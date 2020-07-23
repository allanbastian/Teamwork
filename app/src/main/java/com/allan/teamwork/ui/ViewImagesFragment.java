package com.allan.teamwork.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.allan.teamwork.R;
import com.allan.teamwork.adapters.PhotoRecyclerAdapter;
import com.allan.teamwork.data.models.PhotoItem;
import com.allan.teamwork.data.models.PhotoResponse;
import com.allan.teamwork.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewImagesFragment extends Fragment {

    private RecyclerView photoRecycler;
    private List<Phoot>

    public ViewImagesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_view_images, container, false);
        Call<PhotoResponse> call = ApiUtils.getApiService().getPhotos();
        call.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    List<PhotoResponse> photos = response.body();
                    adapter = new PhotoRecyclerAdapter(getContext(), photos);
                }
            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {

            }
        });
        return rootView;
    }
}