package no.pamir.pamirnewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static no.pamir.pamirnewproject.MainActivity.albumID;
import static no.pamir.pamirnewproject.MainActivity.responseAll;
import static no.pamir.pamirnewproject.MainActivity.userID;

public class PhotosActivity extends AppCompatActivity {
RecyclerView listPhotos;
    List<Photo> photoArrayList=new ArrayList<Photo>();
    AdapterPhotos adapterPhotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        listPhotos=findViewById(R.id.listPhotos);
        listPhotos.setLayoutManager(new GridLayoutManager(this, 2));
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(PhotosActivity.this);
//        listPhotos.setLayoutManager(mLayoutManager);

        photoArrayList=responseAll.body().getUsers().get(userID).getAlbumList().get(albumID).getPhotos();
        Log.e("albumLists ",photoArrayList.get(0).getPhotoName()+",userID"+userID);
        adapterPhotos=new AdapterPhotos(PhotosActivity.this,photoArrayList);
        listPhotos.setAdapter(adapterPhotos);
    }
}
