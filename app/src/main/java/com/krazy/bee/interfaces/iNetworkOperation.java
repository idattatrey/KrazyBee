package com.krazy.bee.interfaces;


import com.krazy.bee.network.models.albums.Album;
import com.krazy.bee.network.models.photos.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iNetworkOperation {

    @GET("albums")
    Call<List<Album>> getAlbums();

    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("albumId") int albumId);
}
