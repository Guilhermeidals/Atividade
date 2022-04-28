package eventelecom.com.example.atividade4.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import eventelecom.com.example.atividade4.adapters.CommentsAdapter;
import eventelecom.com.example.atividade4.adapters.UserAdapter;
import eventelecom.com.example.atividade4.model.Comments;
import eventelecom.com.example.atividade4.model.User;

public class FourthActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null, this, this);

        queue.add(request);

        View HomeBtn = findViewById(R.id.FABack);
        View NextBtn = findViewById(R.id.FANext);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                Toast.makeText(FourthActivity.this, "Avançando", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());
                list.add(new User(response.getJSONObject(i).getInt("id"), response.getJSONObject(i).getString("username"), response.getJSONObject(i).getString("name"), response.getJSONObject(i).getString("email")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        UserAdapter uAdapt = new UserAdapter(list);
        RecyclerView rv = findViewById(R.id.FARV);
        rv.setAdapter(uAdapt);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }
}