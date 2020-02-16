package no.pamir.pamirnewproject;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import static no.pamir.pamirnewproject.MainActivity.userID;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyViewHolder> {
    View row;
    Activity context;
    List<User> arr=new ArrayList<>();

    public AdapterUsers(Activity context, List<User> arr) {
        this.context = context;
        this.arr = arr;
    }

    public List<User> getData() {
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
         row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //final String material_name= arr.get(position).getProductName();

        User orderDetail=new User();
        orderDetail=arr.get(position);
        holder.txtUsername.setText(orderDetail.getUser());
        holder.txtUserAddress.setText(orderDetail.getUserAddress());

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,AlbumsActivity.class);
                userID=position;
                context.startActivity(i);
            }
        });
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


