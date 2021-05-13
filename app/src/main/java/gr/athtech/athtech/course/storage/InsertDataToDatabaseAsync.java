package gr.athtech.athtech.course.storage;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import gr.athtech.athtech.course.storage.database.ApplicationDatabase;
import gr.athtech.athtech.course.storage.database.Movies;

public class InsertDataToDatabaseAsync extends AsyncTask<String, Void, Boolean> {

    private ApplicationDatabase applicationDatabase;
    private InsertDataCallback listener;

    public InsertDataToDatabaseAsync(Context context, InsertDataCallback listener) {
        applicationDatabase = Room.databaseBuilder(context, ApplicationDatabase.class, "storage").build();
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(String... lists) {
        try {
            for (String movieName : lists) {
                Movies movies = new Movies(movieName, "", "", "", "", 5.0, false);
                applicationDatabase.getMovieDao().insertData(movies);
            }
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        listener.onResult(aBoolean);
    }
}
