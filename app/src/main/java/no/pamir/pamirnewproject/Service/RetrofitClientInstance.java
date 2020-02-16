package no.pamir.pamirnewproject.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amit on 20/9/18.
 */

public class RetrofitClientInstance {


    private static Retrofit retrofit;
    private static final String BASE_URL = "http://my-json-server.typicode.com/pamrwt/PamirNewProject2/";
//    private static final String BASE_URL = "http:///vendor/index.php/";

      static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://my-json-server.typicode.com/pamrwt/PamirNewProject2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getApiClient(){
        return  getRetrofitInstance().create(ApiInterface.class);
    }

}
