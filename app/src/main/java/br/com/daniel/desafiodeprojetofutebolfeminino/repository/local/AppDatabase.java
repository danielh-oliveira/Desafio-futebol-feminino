package br.com.daniel.desafiodeprojetofutebolfeminino.repository.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
