package no.pamir.pamirnewproject;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static no.pamir.pamirnewproject.MainActivity.albumID;
import static no.pamir.pamirnewproject.MainActivity.userID;

public class AdapterAlbums extends RecyclerView.Adapter<AdapterAlbums.MyViewHolder> {

    Activity context;
    List<AlbumList> arr=new ArrayList<>();
    View row;
    public AdapterAlbums(Activity context, List<AlbumList> arr) {
        this.context = context;
        this.arr = arr;
    }

    public List<AlbumList> getData() {
        return arr;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserAddress,txtUsername;
        ImageView img;
        public MyViewHolder(View view) {
            super(view);

            this.txtUsername = view.findViewById(R.id.txtUsername);
            this.img =  view.findViewById(R.id.img);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_list_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //final String material_name= arr.get(position).getProductName();

        AlbumList orderDetail=new AlbumList();
        orderDetail=arr.get(position);
        holder.txtUsername.setText(orderDetail.getAlbumname());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,PhotosActivity.class);
                albumID=position;
                context.startActivity(i);
            }
        });}

    @Override
    public int getItemCount() {
        return (null != arr ? arr.size() : 0);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

}


