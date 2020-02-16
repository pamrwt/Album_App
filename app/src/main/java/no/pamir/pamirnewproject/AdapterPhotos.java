package no.pamir.pamirnewproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.MyViewHolder> {

    Activity context;
    List<Photo> arr=new ArrayList<>();

    public AdapterPhotos(Activity context, List<Photo> arr) {
        this.context = context;
        this.arr = arr;
    }

    public List<Photo> getData() {
        return arr;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserAddress,txtUsername;
        public MyViewHolder(View view) {
            super(view);

            this.txtUsername = view.findViewById(R.id.txtUsername);
            this.txtUserAddress = view.findViewById(R.id.txtUserAddress);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_list_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //final String material_name= arr.get(position).getProductName();

        Photo orderDetail=new Photo();
        orderDetail=arr.get(position);
        holder.txtUsername.setText(orderDetail.getPhotoName());
    }

    @Override
    public int getItemCount() {
        return (null != arr ? arr.size() : 0);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

}


