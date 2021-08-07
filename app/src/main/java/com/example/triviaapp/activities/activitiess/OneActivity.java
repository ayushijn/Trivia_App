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
import com.example.triviaapp.databinding.FirstActivityBinding;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {
    private FirstActivityBinding binding;
    private String answer = " ";
    int arrayid, radiobtnid;
    private String[] answerArray = {"Sachin Tendulkar", "Virat Kohli", "Adam Gilchrist", "Jacques Kallis"};
    private UserRecord userRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.first_activity);
        userRecord = (UserRecord) getIntent().getSerializableExtra("UserRecord");
        setListener();
    }

    private void setListener() {

        binding.nextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.rgAnsTwo.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(OneActivity.this, "select one answer", Toast.LENGTH_SHORT).show();

                } else {
                    radiobtnid = binding.rgAnsTwo.getCheckedRadioButtonId();
                    if (radiobtnid == R.id.one) {
                        arrayid = 0;
                    } else if (radiobtnid == R.id.two) {
                        arrayid = 1;
                    } else if (radiobtnid == R.id.three) {
                        arrayid = 2;
                    } else if (radiobtnid == R.id.four) {
                        arrayid = 3;
                    }
                    answer = answerArray[arrayid];
                    userRecord.setAone(answer.trim());

                    Intent i = new Intent(OneActivity.this, TwoActivity.class);
                    i.putExtra("UserRecord", userRecord);
                    startActivity(i);
                }
            }
        });
    }
}
