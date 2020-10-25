package com.example.catalog.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.catalog.util.Constants;
import com.google.gson.annotations.SerializedName;

public class TvShow implements Parcelable {
    @SerializedName("id")
    private String id_show;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String cover;

    @SerializedName("name")
    private String title;

    @SerializedName("overview")
    private String description;

    @SerializedName("first_air_date")
    private String releaseDate;

    public TvShow() {
    }


    public TvShow(String id_show, String popularity, String poster, String cover, String title, String description, String releaseDate) {
        this.id_show = id_show;
        this.popularity = popularity;
        this.poster = poster;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }


    protected TvShow(Parcel in) {
        id_show = in.readString();
        popularity = in.readString();
        poster = in.readString();
        cover = in.readString();
        title = in.readString();
        description = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_show);
        parcel.writeString(popularity);
        parcel.writeString(poster);
        parcel.writeString(cover);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(releaseDate);
    }

    public String getId_show() {
        return id_show;
    }

    public void setId_show(String id_show) {
        this.id_show = id_show;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {

        return Constants.BASE_IMAGE_URL + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCover() {

        return Constants.BASE_IMAGE_URL + cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public static Creator<TvShow> getCREATOR() {
        return CREATOR;
    }
}




