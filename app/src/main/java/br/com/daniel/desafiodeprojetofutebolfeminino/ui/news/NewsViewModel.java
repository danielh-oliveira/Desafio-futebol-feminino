package br.com.daniel.desafiodeprojetofutebolfeminino.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        news = new MutableLiveData<>();

        //TODO Deletar esse mock depois
        List<News> mockNews = new ArrayList<>();
        mockNews.add(new News("Assista à Central do ge: com jovens em destaque, Fla se prepara para Libertadores","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electro"));
        mockNews.add(new News("Palmeiras produz maior expectativa de gol na rodada do Brasileiro; veja números de todos os jogos","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electro"));
        mockNews.add(new News("Zagueiro da Seleção viu Corinthians x Boca no meio de organizada","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electro"));
        mockNews.add(new News("Bragantino contesta linha traçada em revisão de gol anulado e cobra explicações da CBF","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electro"));

        news.setValue(mockNews);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}