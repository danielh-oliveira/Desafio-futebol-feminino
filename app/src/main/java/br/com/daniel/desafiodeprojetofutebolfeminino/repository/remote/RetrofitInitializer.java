package br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializer {
    private static Retrofit retrofit;
    private static SoccerNewsAPI newsService;

    private RetrofitInitializer() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://danielh-oliveira.github.io/soccer-news-api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(SoccerNewsAPI.class);
        }
    }

    public static SoccerNewsAPI getNewsService() {
        if (retrofit != null) {
            return newsService;
        } else {
            return new RetrofitInitializer().getNewsService();
        }
    }

}
