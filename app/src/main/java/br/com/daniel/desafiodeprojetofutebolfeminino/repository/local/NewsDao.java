package br.com.daniel.desafiodeprojetofutebolfeminino.repository.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getAllNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(News news);

    @Query("SELECT * FROM news WHERE favorite = 1")
    List<News> getNewsFavorites();
}
