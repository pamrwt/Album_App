package no.pamir.pamirnewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import no.pamir.pamirnewproject.Service.ApiInterface;
import no.pamir.pamirnewproject.Service.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView listUsers;
List<User> userList=new ArrayList<User>();
public static int userID;
public static int albumID;
  public static   Response<ResponseJSON> responseAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//new changesb
        listUsers=findViewById(R.id.listUsers);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        listUsers.setLayoutManager(mLayoutManager);


        orderList();
    }


    public void orderList(){
        try {
            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();


            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String emp_code = preferences.getString("emp_code", "");
            Log.e("emp_code ", emp_code + "");
            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            mapiClinet.getUserData().enqueue(new Callback<ResponseJSON>() {
                @Override
                public void onResponse(@NonNull Call<ResponseJSON> call, @NonNull Response<ResponseJSON> response) {

//                Toast.makeText(getApplicationContext(), "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    // String msg=response.body().getError_msg();
                    if (response.body() != null) {
                        if (response.body().getUsers().size()>0) {
                            responseAll=response;
                            userList=response.body().getUsers();
                            AdapterUsers adapterUsers=new AdapterUsers(MainActivity.this,userList);
                            listUsers.setAdapter(adapterUsers);
                            Log.e("message ", response.body().getUsers().toString());
                        } else {

                            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Something went wrong try again", Toast.LENGTH_LONG).show();
                        //  Toast.makeText(getApplicationContext(), "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext(), "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                    }


                    progressDialog.dismiss();
                }
                //  showTaost(msg);


                @Override
                public void onFailure(Call<ResponseJSON> call, Throwable t) {
                    progressDialog.dismiss();
//                hideLoading();
                    Toast.makeText(getApplicationContext(), "Something went Wrong...Try Again", Toast.LENGTH_LONG).show();
                    //showTaost("somwthing wet wrong,try later");
                }

            });


        }catch (Exception e){}
    }



}
