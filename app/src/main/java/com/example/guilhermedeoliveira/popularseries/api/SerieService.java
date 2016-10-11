package com.example.guilhermedeoliveira.popularseries.api;

import com.example.guilhermedeoliveira.popularseries.model.Serie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by guilhermeoliveira on 10/10/16.
 */

public interface SerieService {

    public static final String CLIENT_ID =
            "30bbec5288d3c9018ad9b9aef2460651782e0c081a1ef0d77288e20d58b6b343";

    // @GET("movies/popular")
    @GET("shows/popular")
    Call<List<Serie>> getPopularSeries();
    //Call<List<Serie>> getPopularSeries(@Query("page") Integer pageNo, @Query("limit") Integer limit);

    // testing with cUrl

    /**
     * shows:
     * curl --include --head-header
     * "trakt-api-version: 2" --header "trakt-api-key:
     * 30bbec5288d3c9018ad9b9aef2460651782e0c081a1ef0d77288e20d58b6b343"
     * 'https://api.trakt.tv/shows/popular'
     */

    /**
     * seasons:
     * curl --include --header "Content-Type: application/json"
     * --header "trakt-api-version: 2" --header "trakt-api-key:
     * 30bbec5288d3c9018ad9b9aef2460651782e0c081a1ef0d77288e20d58b6b343"
     * 'https://api.trakt.tv/shows/game-of-thrones/seasons'
     */
}
