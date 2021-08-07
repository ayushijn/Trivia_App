package com.example.triviaapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.triviaapp.R;
import com.example.triviaapp.activities.activitiess.HistoryActivity;
import com.example.triviaapp.activities.activitiess.OneActivity;
import com.example.triviaapp.activities.activitiess.SumActivity;
import com.example.triviaapp.activities.models.UserRecord;
import com.example.triviaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String name;
    UserRecord userRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.game.animate().scaleXBy(1.2f).scaleYBy(1.2f).setDuration(3000).start();

        setListener();
        userRecord = new UserRecord();
    }

    private void setListener() {

        binding.nextBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.etName.getText().toString().trim();
                if (name.isEmpty() || name.length() <= 4) {
                    binding.etName.setError("Enter your Name");
                    binding.etName.requestFocus();
                } else {
                    userRecord.setName(name);
                    Intent i = new Intent(MainActivity.this, OneActivity.class);
                    i.putExtra("UserRecord", userRecord);
                    startActivity(i);
                }

            }
        });
        binding.historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });
    }

}
