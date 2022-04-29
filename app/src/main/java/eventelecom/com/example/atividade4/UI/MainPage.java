package eventelecom.com.example.atividade4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import eventelecom.com.example.atividade4.R;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        View HomeBtn = findViewById(R.id.MPHomeButton);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PostsActivity.class);
                Toast.makeText(MainPage.this, "Iniciando", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                }
        });

    }
}