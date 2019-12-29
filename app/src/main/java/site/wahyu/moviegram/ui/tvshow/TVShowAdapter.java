package site.wahyu.moviegram.ui.tvshow;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowHolder> {

    private ArrayList<TVShow> listTvShow = new ArrayList<>();
    private OnTvShowItemClicked clickHandler;

    void setClickHandler(OnTvShowItemClicked clickHandler) {
        this.clickHandler = clickHandler;
    }

    void setListTvShow(ArrayList<TVShow> listTvShow) {
        this.listTvShow.clear();
        this.listTvShow = convertDate(listTvShow);
    }

    @NonNull
    @Override
    public TVShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie_list, parent, false);
        return new TVShowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowHolder holder, int position) {
        TVShow tvShow = listTvShow.get(position);

        GlideApp.with(holder.itemView.getContext())
                .load(Config.URL_IMG_TM_DB_ORIGINAL + "/" + tvShow.getPoster_path() + "?api_key=" + Config.API_KEY)
                .placeholder(R.color.colorText)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fallback(R.color.colorAccent)
                .error(R.color.colorAccent)
                .apply(new RequestOptions().override(200, 400))
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class TVShowHolder extends RecyclerView.ViewHolder {

        ImageView poster;

        TVShowHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_poster);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                TVShow m = listTvShow.get(position);
                clickHandler.tvShowItemClicked(m);
            });
        }
    }

    public interface OnTvShowItemClicked{
        void tvShowItemClicked(TVShow m);
    }

    private ArrayList<TVShow> convertDate(List<TVShow> listTVShow){
        ArrayList<TVShow> temp = new ArrayList<>();
        for (int i=0; i < listTVShow.size(); i++){

            @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
            String startDateStr = listTVShow.get(i).getFirst_air_date();
            try {
                Date date = inputFormat.parse(startDateStr);
                assert date != null;
                String startDateStrNewFormat = outputFormat.format(date);
                listTVShow.get(i).setFirst_air_date(startDateStrNewFormat);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            temp.add(listTVShow.get(i));
        }
        return temp;
    }
}
