
package com.example.catalog.network;

import com.example.catalog.model.CastResponse;
import com.example.catalog.model.GenreResponse;
import com.example.catalog.model.MovieResponse;
import com.example.catalog.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {
    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);

    @GET("discover/tv")
    Call<TvShowResponse> getTvShow(@Query("api_key")String apiKey);

    @GET("{type}/{id}")
    Call<GenreResponse> getGenres(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);


    @GET("movie/{movie_id}")
    Call<MovieResponse> getDetailMovies(@Path("movie_id") int movieid, @Query("api_key") String apiKey);

    @GET("{type}/{id}/credits") // get casts of specific movie / tv shows
    Call<CastResponse> getCasts(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

}
