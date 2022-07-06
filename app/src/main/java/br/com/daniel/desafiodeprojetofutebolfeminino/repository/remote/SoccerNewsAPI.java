package br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsAPI {

    @GET("news-api.json")
    Call<List<News>> getRemoteNews();
}
