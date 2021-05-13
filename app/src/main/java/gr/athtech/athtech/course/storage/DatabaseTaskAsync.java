package gr.athtech.athtech.course.storage;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.athtech.course.storage.database.ApplicationDatabase;
import gr.athtech.athtech.course.storage.database.Movies;

public class DatabaseTaskAsync extends AsyncTask<String, Void, RetrievalDataType> { // Params, Progress, Result

    private ApplicationDatabase applicationDatabase;
    private DatabaseTaskCallback listener;

    public DatabaseTaskAsync(Context context, DatabaseTaskCallback listener) {
        applicationDatabase = Room.databaseBuilder(context, ApplicationDatabase.class, "storage").build();
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected RetrievalDataType doInBackground(String... strings) {
        List<String> action = new ArrayList<>();
        for (String act : strings) {
            action.add(act);
        }

        if (action.contains("First")) {
            Movies movies = applicationDatabase.getMovieDao().getFirst();

            List items = new ArrayList<Movies>();
            items.add(movies);
            return new RetrievalDataType("First", items);
        } else {
            List<Movies> array = applicationDatabase.getMovieDao().getAll();
            return new RetrievalDataType("Default", array);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(RetrievalDataType s) {
        super.onPostExecute(s);

        if (s.getAction().equals("First")) {
            listener.retrieveOnlyOneItem(s.getResults().get(0));
        } else {
            listener.retrieveDatabaseMovies(s.getResults());
        }
    }
}
