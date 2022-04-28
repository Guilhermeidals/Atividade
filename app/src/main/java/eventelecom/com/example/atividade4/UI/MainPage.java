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
        View NextBtn = findViewById(R.id.MPNextButton);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainPage.class);
                Toast.makeText(MainPage.this, "Voltando", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                }
        });

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                Toast.makeText(MainPage.this,"Avançando",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}