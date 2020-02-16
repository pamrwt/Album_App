
package no.pamir.pamirnewproject;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Photo {

    @SerializedName("photoName")
    private String mPhotoName;
    @SerializedName("photoURL")
    private String mPhotoURL;

    public String getPhotoName() {
        return mPhotoName;
    }

    public void setPhotoName(String photoName) {
        mPhotoName = photoName;
    }

    public String getPhotoURL() {
        return mPhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        mPhotoURL = photoURL;
    }

}
