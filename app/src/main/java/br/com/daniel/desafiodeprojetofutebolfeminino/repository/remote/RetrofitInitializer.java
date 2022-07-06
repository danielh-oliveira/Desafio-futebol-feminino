package br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializer {
    private static Retrofit retrofit;
    public static SoccerNewsAPI newsService;

    public RetrofitInitializer() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://danielh-oliveira.github.io/soccer-news-api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(SoccerNewsAPI.class);
        }
    }

}
