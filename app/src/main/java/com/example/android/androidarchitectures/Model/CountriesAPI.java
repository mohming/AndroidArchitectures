package com.example.android.androidarchitectures.Model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CountriesAPI {
    // get the endpoint of the URL
    @GET("all")
    Single<List<Country>> getCountries();
}
