package eventelecom.com.example.atividade4.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import eventelecom.com.example.atividade4.R;
import eventelecom.com.example.atividade4.databinding.ActivityUsersDetailsBinding;
import eventelecom.com.example.atividade4.databinding.LayoutUsersViewholderBinding;
import eventelecom.com.example.atividade4.model.User;

public class UsersDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        ActivityUsersDetailsBinding binding = ActivityUsersDetailsBinding.inflate(layoutInflater);
        setContentView(binding.getRoot());
        User user = getIntent().getExtras().getParcelable("addr_user");
        binding.setUser(user);
        Log.d("inferno:",user.getUserAddress().getCity());
    };
}

