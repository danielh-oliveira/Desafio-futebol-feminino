package br.com.daniel.desafiodeprojetofutebolfeminino.ui.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.daniel.desafiodeprojetofutebolfeminino.R;
import br.com.daniel.desafiodeprojetofutebolfeminino.databinding.ItemNewsBinding;
import br.com.daniel.desafiodeprojetofutebolfeminino.model.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;
    private final FavoriteListener favoriteListener;

    public NewsAdapter(List<News> news, FavoriteListener favoriteListener) {
        this.news = news;
        this.favoriteListener = favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemNewsBinding binding = ItemNewsBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = this.news.get(position);

        implementsTextAndImage(holder, news);
        implementBrowserButton(holder, news);
        implementShareButton(holder, news);


        holder.binding.ButtonFavorites.setOnClickListener(view -> {
            news.favorite = !news.favorite;

            int favoriteColor = news.favorite ? R.color.teal_200 : R.color.black;
            holder.binding.ButtonFavorites.setColorFilter(holder.itemView.getContext().getResources().getColor(favoriteColor));

            this.favoriteListener.onFavorite(news);
            notifyItemChanged(position);
        });
    }



    private void implementShareButton(@NonNull ViewHolder holder, News news) {
        holder.binding.ButtonShare.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, news.getUrl());
            holder.itemView.getContext().startActivity(Intent.createChooser(i, "Share via"));
        });
    }

    private void implementsTextAndImage(@NonNull ViewHolder holder, News news) {
        holder.binding.tvTitle.setText(news.getTitle());
        holder.binding.tvSecondary.setText(news.getDescription());
        Picasso.get().load(news.getImage()).into(holder.binding.ivFirst);
    }

    private void implementBrowserButton(@NonNull ViewHolder holder, News news) {
        holder.binding.Button1.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.getUrl()));
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemNewsBinding binding;

        public ViewHolder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface FavoriteListener {
        void onFavorite(News news);
    }
}

