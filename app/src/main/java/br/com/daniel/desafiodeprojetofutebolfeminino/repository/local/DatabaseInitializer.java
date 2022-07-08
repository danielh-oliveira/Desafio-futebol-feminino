package br.com.daniel.desafiodeprojetofutebolfeminino.repository.local;

import android.content.Context;

import androidx.room.Room;

public class DatabaseInitializer {
    private static AppDatabase db;

    public DatabaseInitializer() {
    }

    public static AppDatabase getDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "db").allowMainThreadQueries().build();
        }
        return db;
    }
}
