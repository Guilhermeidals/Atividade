package eventelecom.com.example.atividade4.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.adapters.PhotosAdapter;
import eventelecom.com.example.atividade4.model.Photos;

public class PhotosActivity extends AppCompatActivity implements Response.Listener<JSONArray>,Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url,null,this,this);

        queue.add(request);

        View backBtn = findViewById(R.id.PhotosBack);
        View homeBtn = findViewById(R.id.PhotosHome);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(),MainPage.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        List<Photos> list = new ArrayList<>();

        for (int i = 0; i < response.length(); i++){
            try {
                list.add(new Photos(response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getInt("albumId"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getString("url"),
                        response.getJSONObject(i).getString("thumbnailUrl")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        PhotosAdapter PAdapter = new PhotosAdapter(list);
        RecyclerView rv = findViewById(R.id.PhotosRV);
        rv.setAdapter(PAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}