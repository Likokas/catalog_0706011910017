package com.example.catalog.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.catalog.model.Cast;
import com.example.catalog.model.CastResponse;
import com.example.catalog.model.Genre;
import com.example.catalog.model.GenreResponse;
import com.example.catalog.model.TvShow;
import com.example.catalog.model.TvShowResponse;
import com.example.catalog.network.RetrofitSevices;
import com.example.catalog.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRepository {

    private static TvShowRepository tvShowRepository;
    //    private ApiEndpoint apiEndpoint;
    private RetrofitSevices service;
    private static final String TAG = "TvShowRepository";

    private TvShowRepository() {
        service = RetrofitSevices.getInstance();
    }

    public static TvShowRepository getInstance(){
        if (tvShowRepository == null){
            tvShowRepository = new TvShowRepository();
        }
        return tvShowRepository;
    }

    public MutableLiveData<List<TvShow>> getTvShowCollection(){
        MutableLiveData<List<TvShow>> listTvShow = new MutableLiveData<>();

        service.getTvShow().enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listTvShow.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

        return listTvShow;
    }
    public  MutableLiveData<List<Genre>> getGenre(int id){
        MutableLiveData<List<Genre>> listGenres = new MutableLiveData<>();

        service.getGenres(Constants.Type.MOVIES, id).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getGenres().size());
                        listGenres.postValue(response.body().getGenres());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

        return listGenres;
    }

    public MutableLiveData<List<Cast>> getCasts(int id) {
        MutableLiveData<List<Cast>> listCasts = new MutableLiveData<>();

        service.getCasts(Constants.Type.TV_SHOWS, id).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getCast().size());
                        listCasts.postValue(response.body().getCast());
                    }
                }
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listCasts;
    }

}
