package com.krazy.bee.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krazy.bee.R;
import com.krazy.bee.adapters.AdapterAlbumPhotos;
import com.krazy.bee.network.NetworkInstance;
import com.krazy.bee.network.models.photos.Photo;
import com.krazy.bee.utils.ProgressView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumPhotos extends Fragment {
    private int albumId = 1;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    public void setMyAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.album_photos, container, false);

        mRecyclerView = v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(v.getContext(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }

    private void updateView() {
        NetworkInstance.getInstance().getPhotos(albumId).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                ProgressView.closeProgressDialog();
                List<Photo> photos = response.body();
                mAdapter = new AdapterAlbumPhotos(photos);
                mAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
            }
        });


    }
}
