package br.com.daniel.desafiodeprojetofutebolfeminino.repository.local;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

public class DatabaseInitializer {
    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "db").allowMainThreadQueries().build();
        }
        return db;
    }

    public static AppDatabase getDatabase() {
        if (db != null) {
            return db;
        } else {
            throw new IllegalStateException("Database was not initialized yet");
        }
    }
}
