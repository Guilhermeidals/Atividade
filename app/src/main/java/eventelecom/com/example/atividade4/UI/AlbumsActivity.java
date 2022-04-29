package eventelecom.com.example.atividade4.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
import eventelecom.com.example.atividade4.adapters.AlbumsAdapter;
import eventelecom.com.example.atividade4.model.Albums;

public class AlbumsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url,null,this,this);

        queue.add(request);

        View backBtn = findViewById(R.id.AlbumsBack);
        View nextBtn = findViewById(R.id.AlbumsNext);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), PhotosActivity.class);
//                Toast.makeText(AlbumsActivity.this,"Avançando",Toast.LENGTH_SHORT).show();
//                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        List<Albums> list = new ArrayList<>();

        for (int i=0;i<response.length();i++){
            try {
                list.add(new Albums(response.getJSONObject(i).getInt("userId"),
                        response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getString("title")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        AlbumsAdapter AAdapter = new AlbumsAdapter(list);
        RecyclerView rv = findViewById(R.id.AlbumsRV);
        rv.setAdapter(AAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}