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
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.adapters.UserAdapter;
import eventelecom.com.example.atividade4.model.User;
import eventelecom.com.example.atividade4.model.UserAddress;

public class UsersActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    UserAdapter adapter = new UserAdapter(user -> {
        Intent intent = new Intent(this, UsersDetailsActivity.class);
        intent.putExtra("addr_user", user);
        startActivity(intent);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        RecyclerView rv = findViewById(R.id.FARV);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

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
                Intent intent = new Intent(getApplicationContext(), UsersActivity.class);
                Toast.makeText(UsersActivity.this, "Avançando", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject object = response.getJSONObject(i);

                JSONObject address = object.getJSONObject("address");

                UserAddress userAddress = new UserAddress(
                        address.getString("street"),
                        address.getString("suite"),
                        address.getString("city"),
                        address.getString("zipcode")
                );

                User user = new User(
                        object.getInt("id"),
                        object.getString("username"),
                        object.getString("name"),
                        object.getString("email"),
                        userAddress
                );

                list.add(user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter.setUsers(list);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }
}