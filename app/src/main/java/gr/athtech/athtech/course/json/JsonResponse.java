package gr.athtech.athtech.course.json;

import java.util.List;
import java.util.Objects;

public class JsonResponse {
    private JsonImageResponse images;
    private List<String> change_keys;

    public JsonImageResponse getImages() {
        return images;
    }

    public void setImages(JsonImageResponse images) {
        this.images = images;
    }

    public List<String> getChange_keys() {
        return change_keys;
    }

    public void setChange_keys(List<String> change_keys) {
        this.change_keys = change_keys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponse that = (JsonResponse) o;
        return Objects.equals(images, that.images) &&
                Objects.equals(change_keys, that.change_keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(images, change_keys);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "images=" + images +
                ", change_keys=" + change_keys +
                '}';
    }
}
