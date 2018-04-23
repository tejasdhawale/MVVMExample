package com.example.tejas.mvvmexample.DI;

import com.example.tejas.mvvmexample.Network.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by webwerks on 16/08/17.
 */

@Module
public class RetrofitModule {
    private static Retrofit retrofit = null;

    private static String BASE_URL = "https://reqres.in";

    @Provides
    public static Api provideApi(Retrofit retrofit) {

        return retrofit.create(Api.class);


    }

    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client, Converter.Factory factory) {

        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(factory)
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    public static OkHttpClient provideOkClient() {

        return new OkHttpClient.Builder()
//              .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//              .addInterceptor(new HeaderInterceptor())
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

    }

    @Provides
    public static Converter.Factory provideFactory() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return GsonConverterFactory.create(gson);
    }

//    public static class HeaderInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain)
//                throws IOException {
//            Request request = chain.request();
//            request = request.newBuilder()
////                    .addHeader("authorisation_key", App.getInstance().getAuthenticationKey())
////                    .addHeader("hrms_id", App.getInstance().getHrmsId())
//                    .build();
//            Response response = chain.proceed(request);
//            return response;
//        }
//    }



//    public static Api getClient() {
//
//        if (retrofit == null) {
//            retrofit = provideRetrofit(provideOkClient(), provideFactory());
//        }
//        return retrofit.create(Api.class);
//    }


}
