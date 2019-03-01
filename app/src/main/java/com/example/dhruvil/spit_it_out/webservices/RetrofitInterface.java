package com.example.dhruvil.spit_it_out.webservices;
import com.bumptech.glide.load.model.Model;
import com.example.dhruvil.spit_it_out.Models.Register;
import com.google.gson.JsonElement;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST("confirm_tel.php")
    Call<ResponseBody> gettoken(@Field("to") String to, @Field("token") String token);

    @FormUrlEncoded
    @POST("confirm_tel_store.php")
    Call<ResponseBody> updateOTPOnServer(
            @Field("to") String to,
            @Field("gcm_regid") String gcm_regid,
            @Field("platform") String platform);

    @GET("get_spits.php")
    Call<Model>getpublicspit();
    @FormUrlEncoded
    @POST("register.php")
    Call<JsonElement> registeruser(@Field("regid") String regid, @Field("tel") String tel, @Field("platform") String platform);

}
