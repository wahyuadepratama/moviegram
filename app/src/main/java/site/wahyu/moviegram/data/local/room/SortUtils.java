package site.wahyu.moviegram.data.local.room;

import androidx.sqlite.db.SimpleSQLiteQuery;

public class SortUtils {

    public static final String TITLE = "title";
    public static final String RANDOM = "random";

    public static SimpleSQLiteQuery getSorteredQuery(String filter){
        StringBuilder simpleQuery = new StringBuilder().append("SELECT * FROM favorite_movie ");

        if (filter.equals(TITLE)){
            simpleQuery.append("ORDER BY title");
        }else if(filter.equals(RANDOM)){
            simpleQuery.append("WHERE ORDER BY RANDOM()");
        }

        return new SimpleSQLiteQuery(simpleQuery.toString());
    }
}
