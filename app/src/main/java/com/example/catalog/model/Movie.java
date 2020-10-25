package com.example.catalog.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.catalog.util.Constants;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
    @SerializedName("id")
    private String id_movie;

    @SerializedName("popularity")
    private  String popularity;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private  String cover;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private  String description;

    @SerializedName("release_date")
    private String releasedate;


    public Movie() {

    }


    public Movie(String popularity, String poster, String cover, String title, String description, String releasedate) {
        this.popularity = popularity;
        this.poster = poster;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.releasedate = releasedate;
    }

    public String getId_movie() {
        return id_movie;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {
        return Constants.BASE_IMAGE_URL+poster;
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

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.popularity);
        dest.writeString(this.poster);
        dest.writeString(this.cover);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.releasedate);
    }

    protected Movie(Parcel in) {
        this.popularity = in.readString();
        this.poster = in.readString();
        this.cover = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.releasedate = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
