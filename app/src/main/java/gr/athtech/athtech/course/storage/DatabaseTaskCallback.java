package gr.athtech.athtech.course.storage;

import java.util.List;

import gr.athtech.athtech.course.storage.database.Movies;

public interface DatabaseTaskCallback {

    public void retrieveDatabaseMovies(List<Movies> array);

    void retrieveOnlyOneItem(Movies item);
}
