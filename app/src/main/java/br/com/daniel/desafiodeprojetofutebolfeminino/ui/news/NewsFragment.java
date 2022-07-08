package br.com.daniel.desafiodeprojetofutebolfeminino.ui.news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import br.com.daniel.desafiodeprojetofutebolfeminino.databinding.FragmentNewsBinding;
import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.AppDatabase;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.DatabaseInitializer;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.NewsDao;
import br.com.daniel.desafiodeprojetofutebolfeminino.ui.adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private AppDatabase DB;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        DB = DatabaseInitializer.getDatabase(getContext());
        NewsDao newsDao = DB.newsDao();

        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.rvNews.setAdapter(new NewsAdapter(news, updatedNews -> {
                newsDao.insert(updatedNews);
            }));
        });
        newsViewModel.getStatus().observe(getViewLifecycleOwner(), status -> {
            Toast.makeText(getActivity(), "An error occurred while fetching news", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}