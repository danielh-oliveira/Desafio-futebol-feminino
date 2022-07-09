package br.com.daniel.desafiodeprojetofutebolfeminino.repository;

import android.content.Context;

import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.AppDatabase;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.DatabaseInitializer;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote.RetrofitInitializer;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote.SoccerNewsAPI;

public class Repository {
    public final AppDatabase database;
    public final SoccerNewsAPI newsService;

    private Repository(Context context) {
        database = DatabaseInitializer.getDatabase(context);
        newsService = RetrofitInitializer.getNewsService();
    }

    public static void initialize(Context context) {
        LazyHolder.INSTANCE = new Repository(context);
    }

    public static Repository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static Repository INSTANCE;
    }
}
