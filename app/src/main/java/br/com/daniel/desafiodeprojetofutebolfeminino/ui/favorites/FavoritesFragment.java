package br.com.daniel.desafiodeprojetofutebolfeminino.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.databinding.FragmentFavoritesBinding;
import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.Repository;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.DatabaseInitializer;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.NewsDao;
import br.com.daniel.desafiodeprojetofutebolfeminino.ui.adapter.NewsAdapter;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;
    private NewsDao newsDao = Repository.getInstance().database.newsDao();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        loadFavorites();

        return root;
    }

    private void loadFavorites() {
        List<News> newsFavorites = newsDao.getNewsFavorites();

        binding.rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFavorites.setAdapter(new NewsAdapter(newsFavorites, updatedNews -> {
            newsDao.update(updatedNews);
        }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}