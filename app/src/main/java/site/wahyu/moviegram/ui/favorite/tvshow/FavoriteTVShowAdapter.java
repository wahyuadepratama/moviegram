package site.wahyu.moviegram.ui.favorite.tvshow;

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
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.ui.tvshow.detail.TVShowDetailActivity;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;

public class FavoriteTVShowAdapter extends PagedListAdapter<FavoriteTVShowEntity, FavoriteTVShowAdapter.FavoriteTVShowViewHolder> {

    FavoriteTVShowAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FavoriteTVShowAdapter.FavoriteTVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie_list, parent, false);
        return new FavoriteTVShowAdapter.FavoriteTVShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTVShowAdapter.FavoriteTVShowViewHolder holder, int position) {
        FavoriteTVShowEntity tvshow = getItem(position);

        holder.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (tvshow != null){
            GlideApp.with(holder.itemView.getContext())
                    .load(Config.URL_IMG_TM_DB + "/" + tvshow.getPoster_path() + "?api_key=" + Config.API_KEY)
                    .placeholder(R.color.colorText)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fallback(R.color.colorAccent)
                    .error(R.color.colorAccent)
                    .apply(new RequestOptions().override(200, 400))
                    .into(holder.poster);

            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, TVShowDetailActivity.class);

                TVShow tvShow = new TVShow(tvshow.getId(), tvshow.getPoster_path(), tvshow.getName(), tvshow.getOverview(), tvshow.getFirst_air_date());
                intent.putExtra(Config.EXTRA_TV_SHOW, tvShow);
                context.startActivity(intent);
            });
        }
    }

    class FavoriteTVShowViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        LinearLayout linearLayout;

        FavoriteTVShowViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.img_poster);
            linearLayout = itemView.findViewById(R.id.layout_item_movie);
        }
    }

    private static DiffUtil.ItemCallback<FavoriteTVShowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteTVShowEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteTVShowEntity oldItem, @NonNull FavoriteTVShowEntity newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteTVShowEntity oldItem, @NonNull FavoriteTVShowEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
