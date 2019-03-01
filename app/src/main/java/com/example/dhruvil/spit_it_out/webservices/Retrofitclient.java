package com.example.dhruvil.spit_it_out.webservices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {

        public static final String BASE_URL = "http://106.201.232.72/spit_api/ws/";
        private static retrofit2.Retrofit retrofit = null;


        public static Retrofit getClient() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }


