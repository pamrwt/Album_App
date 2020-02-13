package no.pamir.pamirnewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//new changesb

        JSONObject j1=new JSONObject();
        JSONObject j2=new JSONObject();
        JSONArray ja1 =new JSONArray();
        JSONArray ja2 =new JSONArray();

        for (int i = 1; i<= 2; i++) {
            try {
                JSONObject cust = new JSONObject();

                cust.put("userName","user"+ i);
                j2.put("albumName","album"+ i);
//                j2.put("albumName","album"+String.valueOf(i));
//                ja2.put(j2);
//            cust.put("name","customer"+i);
//            cust.put("url","url"+i);


                ja2.put(j2);
                cust.put("albumList",ja2);
                ja1.put(cust);
            ja1.put(ja2);
            j1.put("Allusers ",ja1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        }
        Log.e("json array ",j1.toString());

    }
}
