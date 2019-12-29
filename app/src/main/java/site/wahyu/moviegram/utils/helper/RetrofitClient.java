package site.wahyu.moviegram.utils.helper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import site.wahyu.moviegram.utils.config.Config;

public class RetrofitClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(Config.URL_TM_DB)
                            .addConverterFactory(
                                    GsonConverterFactory.create()
                            );

            retrofit = builder.client(httpClient.build()).build();
        }
        return retrofit;
    }
}
