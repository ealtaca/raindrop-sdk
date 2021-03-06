package com.raindrop.sdk;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ealtaca on 15.05.2018.
 */

public class Whitelist extends BaseApiResponse {

    @SerializedName("hydro_address_id")
    private String hydroAddressId;

    public String getHydroAddressId() {
        return hydroAddressId;
    }

    public void setHydroAddressId(String hydroAddressId) {
        this.hydroAddressId = hydroAddressId;
    }

    @Override
    public String toString() {
        return "com.raindrop.sdk.Whitelist{" +
                "success='" + super.isSuccess() + '\'' +
                "message='" + super.getMessage() + '\'' +
                "hydroAddressId='" + hydroAddressId + '\'' +
                '}';
    }
}