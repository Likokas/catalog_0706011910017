package com.example.catalog.network;

import com.example.catalog.model.CastResponse;
import com.example.catalog.model.GenreResponse;
import com.example.catalog.model.MovieResponse;
import com.example.catalog.model.TvShowResponse;
import com.example.catalog.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSevices {
//    private static Retrofit retrofit;
//
//    public static <S> S createService(Class<S> serviceClass){
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit.create(serviceClass);
    private ApiEndpoints api;
    private static RetrofitSevices service;

    private RetrofitSevices(){
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiEndpoints.class);

    }

    public static RetrofitSevices getInstance(){
        if (service == null){
            service = new RetrofitSevices();
        }
        return service;
    }

    public Call<MovieResponse> getMovies(){
        return api.getMovies(Constants.API_KEY);
    }
    public Call<TvShowResponse> getTvShow(){
        return api.getTvShow(Constants.API_KEY);
    }

    public Call<GenreResponse> getGenres(String type, int id) {
        return api.getGenres(type, id, Constants.API_KEY);
    }

    public Call<CastResponse> getCasts(String type, int id) {
        return api.getCasts(type, id, Constants.API_KEY);
    }
}