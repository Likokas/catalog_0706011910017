package com.example.catalog.util;

import androidx.annotation.StringDef;

public class Constants {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/original";
    public static final String API_KEY = "55975dadf9b992b168b487532d420b9d";

    public @interface Type{
        String MOVIES = "movie";
        String TV_SHOWS = "tv";
    }








}
