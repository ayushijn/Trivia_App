package com.example.triviaapp.activities.activitiess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.triviaapp.R;
import com.example.triviaapp.activities.MainActivity;
import com.example.triviaapp.activities.models.UserRecord;
import com.example.triviaapp.databinding.ActivityMainBinding;
import com.example.triviaapp.databinding.SecondActivityBinding;

public class TwoActivity extends AppCompatActivity {
    private SecondActivityBinding binding;
    private UserRecord userRecord;
    StringBuilder selected = new StringBuilder("");
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.second_activity);
        userRecord = (UserRecord) getIntent().getSerializableExtra("UserRecord");
        setListener();
    }

    private void setListener() {
        flag = 0;
        binding.nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.optt1.isChecked()) {
                    selected.append("White ");
                    flag = 1;
                }
                if (binding.optt2.isChecked()) {
                    selected.append("Yellow ");
                    flag = 1;
                }
                if (binding.optt3.isChecked()) {
                    selected.append("Orange ");
                    flag = 1;
                }
                if (binding.optt4.isChecked()) {
                    selected.append("Green ");
                    flag = 1;
                }
                if (flag == 0) {
                    Toast.makeText(TwoActivity.this, "Please select options", Toast.LENGTH_SHORT).show();
                } else {
                    userRecord.setAtwo(selected.toString().trim());
                    Intent i = new Intent(TwoActivity.this, SumActivity.class);
                    i.putExtra("UserRecord", userRecord);
                    startActivity(i);
                }
            }
        });

    }

}
