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

import eventelecom.com.example.atividade4.model.Posts;
import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.adapters.PostsAdapter;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null,this, this);

        queue.add(request);

        View HomeBtn = findViewById(R.id.ASHome);
        View NextBtn = findViewById(R.id.ASNext);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CommentsActivity.class);
                Toast.makeText(PostsActivity.this,"Avançando",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        List<Posts> list = new ArrayList<>();

        for(int i = 0; i < response.length(); i++){
            try {
                list.add(new Posts(response.getJSONObject(i).getInt("id"), response.getJSONObject(i).getString("title"), response.getJSONObject(i).getString("body"),
                        response.getJSONObject(i).getInt("userId")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        PostsAdapter pAdapt = new PostsAdapter(list);
        RecyclerView rv = findViewById(R.id.RVPosts);
        rv.setAdapter(pAdapt);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }

}