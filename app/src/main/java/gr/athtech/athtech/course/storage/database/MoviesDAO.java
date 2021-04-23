package gr.athtech.athtech.course.storage.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoviesDAO {

    @Insert
    void insertData(Movies data);

    @Update
    void update(Movies data);

    @Delete
    void delete(Movies data);

    @Query("SELECT * FROM movies WHERE name LIKE :query LIMIT 1")
    Movies find(String query);

    @Query("SELECT * FROM movies WHERE isFavorite = 'true' ")
    List<Movies> getAllFavorites();

    @Query("SELECT * FROM movies")
    List<Movies> getAll();

}
