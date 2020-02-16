package no.pamir.pamirnewproject.Service;

import no.pamir.pamirnewproject.ResponseJSON;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    /*--------Image Upload  API---------------------------*/

//@POST("Vendor_login/login")
//    Call<ResponseLogin> login(@Body ReqLogin request);

@GET("db")
    Call<ResponseJSON> getUserData();



}
