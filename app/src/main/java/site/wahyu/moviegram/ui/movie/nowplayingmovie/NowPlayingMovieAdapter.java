package site.wahyu.moviegram.ui.movie.nowplayingmovie;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;

public class NowPlayingMovieAdapter extends RecyclerView.Adapter<NowPlayingMovieAdapter.PopularMovieHolder> {

    private List<Movie> listMovie = new ArrayList<>();
    private OnNowPlayingMovieItemClicked clickHandler;
    private boolean onFragmentMovieMore;

    public void setClickHandler(OnNowPlayingMovieItemClicked clickHandler) {
        this.clickHandler = clickHandler;
    }

    public void setListMovie(ArrayList<Movie> listMovie, boolean onFragmentMovieMore) {
        this.onFragmentMovieMore = onFragmentMovieMore;
        this.listMovie.clear();
        this.listMovie = convertDate(listMovie);
    }

    @NonNull
    @Override
    public PopularMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie_list, parent, false);
        return new PopularMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieHolder holder, int position) {
        Movie movie = listMovie.get(position);

        if (onFragmentMovieMore)
            holder.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        GlideApp.with(holder.itemView.getContext())
                .load(Config.URL_IMG_TM_DB + "/" + movie.getPoster_path() + "?api_key=" + Config.API_KEY)
                .placeholder(R.color.colorText)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fallback(R.color.colorAccent)
                .error(R.color.colorAccent)
                .apply(new RequestOptions().override(200, 400))
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class PopularMovieHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        LinearLayout linearLayout;

        PopularMovieHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_poster);
            linearLayout = itemView.findViewById(R.id.layout_item_movie);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                Movie m = listMovie.get(position);
                clickHandler.nowPlayingMovieItemClicked(m);
            });
        }
    }

    public interface OnNowPlayingMovieItemClicked{
        void nowPlayingMovieItemClicked(Movie m);
    }

    private ArrayList<Movie> convertDate(List<Movie> listMovie){
        ArrayList<Movie> temp = new ArrayList<>();
        for (int i=0; i < listMovie.size(); i++){

            @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
            String startDateStr = listMovie.get(i).getRelease_date();
            try {
                Date date = inputFormat.parse(startDateStr);
                assert date != null;
                String startDateStrNewFormat = outputFormat.format(date);
                listMovie.get(i).setRelease_date(startDateStrNewFormat);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            temp.add(listMovie.get(i));
        }
        return temp;
    }
}
