package gr.athtech.athtech.course.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class JsonImageResponse implements Serializable, Parcelable {
    private String base_url;
    private String secure_base_url;
    private List<String> backdrop_sizes;
    private List<String> logo_sizes;
    private List<String> poster_sizes;

    protected JsonImageResponse(Parcel in) {
        base_url = in.readString();
        secure_base_url = in.readString();
        backdrop_sizes = in.createStringArrayList();
        logo_sizes = in.createStringArrayList();
        poster_sizes = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(base_url);
        dest.writeString(secure_base_url);
        dest.writeStringList(backdrop_sizes);
        dest.writeStringList(logo_sizes);
        dest.writeStringList(poster_sizes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<JsonImageResponse> CREATOR = new Creator<JsonImageResponse>() {
        @Override
        public JsonImageResponse createFromParcel(Parcel in) {
            return new JsonImageResponse(in);
        }

        @Override
        public JsonImageResponse[] newArray(int size) {
            return new JsonImageResponse[size];
        }
    };

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getSecure_base_url() {
        return secure_base_url;
    }

    public void setSecure_base_url(String secure_base_url) {
        this.secure_base_url = secure_base_url;
    }

    public List<String> getBackdrop_sizes() {
        return backdrop_sizes;
    }

    public void setBackdrop_sizes(List<String> backdrop_sizes) {
        this.backdrop_sizes = backdrop_sizes;
    }

    public List<String> getLogo_sizes() {
        return logo_sizes;
    }

    public void setLogo_sizes(List<String> logo_sizes) {
        this.logo_sizes = logo_sizes;
    }

    public List<String> getPoster_sizes() {
        return poster_sizes;
    }

    public void setPoster_sizes(List<String> poster_sizes) {
        this.poster_sizes = poster_sizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonImageResponse that = (JsonImageResponse) o;
        return Objects.equals(base_url, that.base_url) &&
                Objects.equals(secure_base_url, that.secure_base_url) &&
                Objects.equals(backdrop_sizes, that.backdrop_sizes) &&
                Objects.equals(logo_sizes, that.logo_sizes) &&
                Objects.equals(poster_sizes, that.poster_sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base_url, secure_base_url, backdrop_sizes, logo_sizes, poster_sizes);
    }

    @Override
    public String toString() {
        return "JsonImageResponse{" +
                "base_url='" + base_url + '\'' +
                ", secure_base_url='" + secure_base_url + '\'' +
                ", backdrop_sizes=" + backdrop_sizes +
                ", logo_sizes=" + logo_sizes +
                ", poster_sizes=" + poster_sizes +
                '}';
    }
}