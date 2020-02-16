
package no.pamir.pamirnewproject;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AlbumList {

    @SerializedName("albumname")
    private String mAlbumname;
    @SerializedName("photos")
    private List<Photo> mPhotos;

    public String getAlbumname() {
        return mAlbumname;
    }

    public void setAlbumname(String albumname) {
        mAlbumname = albumname;
    }

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

}
