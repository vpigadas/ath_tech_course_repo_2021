package gr.athtech.athtech.course.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Movies.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

    public abstract MoviesDAO getMovieDao();
}
