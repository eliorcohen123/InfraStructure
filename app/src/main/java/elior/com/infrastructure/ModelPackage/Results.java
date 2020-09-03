package elior.com.infrastructure.ModelPackage;

import java.io.Serializable;
import java.util.List;

public class Results implements Serializable {

    private String id;
    private String name;
    private String vicinity;
    private List<Photos> photos;
    private Geometry geometry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPhotos() {
        return photos.get(0).getPhoto_reference();
    }

    public void setPhotos(String photos) {
        this.photos.get(0).setPhoto_reference(photos);
    }

    public double getLat() {
        return geometry.getLocation().getLat();
    }

    public void setLat(double lat) {
        this.geometry.getLocation().setLat(lat);
    }

    public double getLng() {
        return geometry.getLocation().getLng();
    }

    public void setLng(double lng) {
        this.geometry.getLocation().setLng(lng);
    }

}
