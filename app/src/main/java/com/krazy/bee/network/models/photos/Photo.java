
package com.krazy.bee.network.models.photos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("albumId")
    @Expose
    public Integer albumId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("thumbnailUrl")
    @Expose
    public String thumbnailUrl;

}
