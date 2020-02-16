package no.pamir.pamirnewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static no.pamir.pamirnewproject.MainActivity.responseAll;
import static no.pamir.pamirnewproject.MainActivity.userID;

public class AlbumsActivity extends AppCompatActivity {
    List<AlbumList> albumLists=new ArrayList<AlbumList>();
AdapterAlbums adapterAlbums;
RecyclerView listAlbums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        listAlbums=findViewById(R.id.listAlbums);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(AlbumsActivity.this);
        listAlbums.setLayoutManager(mLayoutManager);

        albumLists=responseAll.body().getUsers().get(userID).getAlbumList();
        Log.e("albumLists ",albumLists.get(0).getAlbumname()+",userID"+userID);
        adapterAlbums=new AdapterAlbums(AlbumsActivity.this,albumLists);
        listAlbums.setAdapter(adapterAlbums);

    }



}
