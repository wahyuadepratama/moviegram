package site.wahyu.moviegram.ui.favorite.movie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.ui.movie.detail.MovieDetailActivity;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;

public class FavoriteMovieAdapter extends PagedListAdapter<FavoriteMovieEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder> {

    FavoriteMovieAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FavoriteMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie_list, parent, false);
        return new FavoriteMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMovieViewHolder holder, int position) {
        FavoriteMovieEntity movie = getItem(position);

        holder.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (movie != null){
            GlideApp.with(holder.itemView.getContext())
                    .load(Config.URL_IMG_TM_DB + "/" + movie.getPoster_path() + "?api_key=" + Config.API_KEY)
                    .placeholder(R.color.colorText)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fallback(R.color.colorAccent)
                    .error(R.color.colorAccent)
                    .apply(new RequestOptions().override(200, 400))
                    .into(holder.poster);

            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, MovieDetailActivity.class);

                Movie movies = new Movie(movie.getId(), movie.getPoster_path(), movie.getTitle(), movie.getOverview(), movie.getRelease_date());
                intent.putExtra(Config.EXTRA_MOVIES, movies);
                context.startActivity(intent);
            });
        }

    }

    class FavoriteMovieViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        LinearLayout linearLayout;

        FavoriteMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.img_poster);
            linearLayout = itemView.findViewById(R.id.layout_item_movie);
        }
    }

    private static DiffUtil.ItemCallback<FavoriteMovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteMovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteMovieEntity oldItem, @NonNull FavoriteMovieEntity newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteMovieEntity oldItem, @NonNull FavoriteMovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
