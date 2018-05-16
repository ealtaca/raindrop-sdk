import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ealtaca on 15.05.2018.
 */

public class RestClient {

    private ApiCredentials apiCredentials;
    private static final String CONTENT_TYPE = "application/json";
    private IHydroService service;
    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    RestClient(String baseUrl,String key,String username) {
        setApiCredentials(key,username);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("content-type", CONTENT_TYPE)
                        .build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(IHydroService.class);
    }

    IHydroService getAPIService() {
        return service;
    }

    ApiCredentials getApiCredentials()
    {
        return apiCredentials;
    }

    private void setApiCredentials(String key,String username)
    {
        apiCredentials = new ApiCredentials(key,username);
    }

}
