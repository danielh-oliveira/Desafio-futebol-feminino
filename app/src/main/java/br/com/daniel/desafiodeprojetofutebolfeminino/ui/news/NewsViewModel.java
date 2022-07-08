package br.com.daniel.desafiodeprojetofutebolfeminino.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.AppDatabase;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.DatabaseInitializer;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.NewsDao;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.remote.RetrofitInitializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final MutableLiveData<Boolean> status = new MutableLiveData<>();

    public NewsViewModel() {
        findNews();
    }

    private void findNews() {
        new RetrofitInitializer().newsService.getRemoteNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    news.setValue(response.body());
                } else {
                    status.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                status.setValue(false);
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return news;
    }

    public LiveData<Boolean> getStatus() {
        return status;
    }

}