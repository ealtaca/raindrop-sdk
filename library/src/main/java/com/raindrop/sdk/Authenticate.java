package com.raindrop.sdk;

/**
 * Created by ealtaca on 15.05.2018.
 */

public class Authenticate extends BaseApiResponse{
    private boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public String toString() {
        return "com.raindrop.sdk.Authenticate{" +
                "success='" + super.isSuccess() + '\'' +
                "message='" + super.getMessage() + '\'' +
                "authenticated=" + authenticated + '}';
    }

}
