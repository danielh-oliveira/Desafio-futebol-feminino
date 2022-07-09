package br.com.daniel.desafiodeprojetofutebolfeminino.ui.favorites;

import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.Repository;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.NewsDao;

public class FavoritesViewModel extends ViewModel {
    private NewsDao newsDao;

    public FavoritesViewModel() {
        newsDao = Repository.getInstance().database.newsDao();
    }

    public List<News> getNewsFavorites() {
        return newsDao.getNewsFavorites();
    }

    public void update(News news) {
        newsDao.update(news);
    }
}