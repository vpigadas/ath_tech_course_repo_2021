package gr.athtech.athtech.course.storage.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class Movies {

    @PrimaryKey  @ColumnInfo(name = "name") @NonNull
    private String name;
    @ColumnInfo(name = "photo_url")
    private String photoUrl;
    @ColumnInfo(name = "cover_photo")
    private String coverUrl;
    @ColumnInfo(name = "release_date")
    private String releaseDate;
    private String description;
    private double rating;
    private boolean isFavorite;

    public Movies(String name, String photoUrl, String coverUrl, String releaseDate, String description, double rating, boolean isFavorite) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.coverUrl = coverUrl;
        this.releaseDate = releaseDate;
        this.description = description;
        this.rating = rating;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
