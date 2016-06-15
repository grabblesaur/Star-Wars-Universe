package com.qqq.starwarsuniverse.rest;

import com.qqq.starwarsuniverse.model.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qqq on 09.06.2016.
 */
public interface SWAPIInterface {
    @GET("people")
    Call<PeopleResponse> getPeopleFromPage();
}
