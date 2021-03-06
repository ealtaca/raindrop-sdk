package com.raindrop.sdk;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

/**
 * Created by ealtaca on 15.05.2018.
 */

public class Challenge extends BaseApiResponse {

    private BigInteger amount;
    private String challenge;

    @SerializedName("partner_id")
    private BigInteger partnerId;

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public BigInteger getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(BigInteger partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public String toString() {
        return "com.raindrop.sdk.Challenge{" +
                "success='" + super.isSuccess() + '\'' +
                "message='" + super.getMessage() + '\'' +
                "amount=" + amount + '\'' +
                "challenge='" + challenge + '\'' +
                "partnerId=" + partnerId + '}';
    }

}
