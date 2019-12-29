package site.wahyu.moviegram.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {

    private int id;
    private String poster_path;
    private String name;
    private String overview;
    private String first_air_date;

    public TVShow(int id, String poster_path, String name, String overview, String first_air_date) {
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

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.poster_path);
        dest.writeString(this.name);
        dest.writeString(this.overview);
        dest.writeString(this.first_air_date);
    }

    protected TVShow(Parcel in) {
        this.id = in.readInt();
        this.poster_path = in.readString();
        this.name = in.readString();
        this.overview = in.readString();
        this.first_air_date = in.readString();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
