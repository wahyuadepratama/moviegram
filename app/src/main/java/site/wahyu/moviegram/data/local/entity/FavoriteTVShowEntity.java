package site.wahyu.moviegram.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite_tvshow")
public class FavoriteTVShowEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "poster_path")
    private String poster_path;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "first_air_date")
    private String first_air_date;

    public FavoriteTVShowEntity(int id, String poster_path, String name, String overview, String first_air_date) {
        this.id = id;
        this.poster_path = poster_path;
        this.name = name;
        this.overview = overview;
        this.first_air_date = first_air_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }
}
