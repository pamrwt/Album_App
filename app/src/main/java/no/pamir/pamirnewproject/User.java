
package no.pamir.pamirnewproject;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("albumList")
    private List<AlbumList> mAlbumList;
    @SerializedName("user")
    private String mUser;
    @SerializedName("userAddress")
    private String mUserAddress;

    public List<AlbumList> getAlbumList() {
        return mAlbumList;
    }

    public void setAlbumList(List<AlbumList> albumList) {
        mAlbumList = albumList;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }

    public String getUserAddress() {
        return mUserAddress;
    }

    public void setUserAddress(String userAddress) {
        mUserAddress = userAddress;
    }

}
