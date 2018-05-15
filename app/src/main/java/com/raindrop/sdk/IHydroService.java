package com.raindrop.sdk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ealtaca on 15.05.2018.
 */

public interface IHydroService {

    @POST("whitelist/{ethAddress}")
    Call<Whitelist> whitelist(@Path("ethAddress") String ethAddress, @Body ApiCredentials apiCredentials);

    @POST("challenge")
    Call<Challenge> challenge(@Query("hydro_address_id") String hydroAddressId, @Body ApiCredentials apiCredentials);

    @POST("authenticate")
    Call<Authenticate> authenticate(@Query("hydro_address_id") String hydroAddressId, @Body ApiCredentials apiCredentials);
}