import android.util.Log;

/**
 * Created by ealtaca on 15.05.2018.
 */

public class HydroAuthenticator {

    private static final String TAG = "HydroAuthenticator";

    private static final String BASE_URL = "https://api.hydrogenplatform.com/hydro/v1/";
    private static final String BASE_TEST_URL = "https://sandbox.hydrogenplatform.com/hydro/v1";

    private RestClient restClient;

    public HydroAuthenticator(String apiKey, String apiUsername, boolean useTestnet) {

        if (apiKey == null || apiKey.isEmpty() || apiUsername == null || apiUsername.isEmpty()) {
            throw new IllegalArgumentException("apiKey and apiUsername can not be null or empty");
        }

        if (useTestnet) {
            this.restClient = new RestClient(BASE_TEST_URL,apiKey,apiUsername);
            Log.i(TAG, "HydroAuthenticator initialized for TestNet");
        } else {
            this.restClient = new RestClient(BASE_URL,apiKey,apiUsername);
            Log.i(TAG, "HydroAuthenticator initialized for MainNet");
        }

    }

    public Whitelist whitelist(String ethAddress) {

        try {
            if (ethAddress == null || ethAddress.isEmpty()) {
                throw new IllegalArgumentException("parameter ethAddress can not be null or empty");
            }
            return restClient.getAPIService().whitelist(ethAddress,restClient.getApiCredentials()).execute().body();

        } catch (Exception e) {
            Log.e(TAG, "An error occurred while whitelist request was performed : " + e.getLocalizedMessage());
            Whitelist whitelist = new Whitelist();
            whitelist.setSuccess(false);
            whitelist.setMessage(e.getMessage());
            return whitelist;
        }
    }

    public Challenge challenge(String hydroAddressId) {

        try {
            if (hydroAddressId == null || hydroAddressId.isEmpty()) {
                throw new IllegalArgumentException("parameter hydroAddressId can not be null or empty");
            }

            return restClient.getAPIService().challenge(hydroAddressId,restClient.getApiCredentials()).execute().body();

        } catch (Exception e) {
            Log.e(TAG, "An error occurred while challenge request was performed : " + e.getLocalizedMessage());
            Challenge challenge = new Challenge();
            challenge.setSuccess(false);
            challenge.setMessage(e.getMessage());
            return challenge;
        }

    }

    public Authenticate authenticate(String hydroAddressId) {

        try {
            if (hydroAddressId == null || hydroAddressId.isEmpty()) {
                throw new IllegalArgumentException("parameter hydroAddressId can not be null or empty");
            }
            return restClient.getAPIService().authenticate(hydroAddressId,restClient.getApiCredentials()).execute().body();

        } catch (Exception e) {
            Log.e(TAG, "An error occurred while challenge request was performed : " + e.getLocalizedMessage());
            Authenticate authenticate = new Authenticate();
            authenticate.setSuccess(false);
            authenticate.setMessage(e.getMessage());
            return authenticate;
        }
    }

}
