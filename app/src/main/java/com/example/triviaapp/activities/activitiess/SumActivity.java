package com.example.triviaapp.activities.activitiess;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.triviaapp.R;
import com.example.triviaapp.activities.MainActivity;
import com.example.triviaapp.activities.adapters.RcAdapter;
import com.example.triviaapp.activities.databases.AppDatabase;
import com.example.triviaapp.activities.models.UserRecord;
import com.example.triviaapp.databinding.ActivityMainBinding;
import com.example.triviaapp.databinding.SumActivityBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SumActivity extends Activity {
    private SumActivityBinding binding;
    private UserRecord userRecord;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sum_activity);
        userRecord = (UserRecord) getIntent().getSerializableExtra("UserRecord");
        showData();
        setListener();
    }

    private void showData() {
        binding.tvAnsOne.setText("Answer : " + userRecord.getAone());
        binding.tvAnsTwo.setText("Answers : " + userRecord.getAtwo());
        binding.hellotv.setText("Hello " + userRecord.getName() + ",");
    }

    private void setListener() {
        binding.finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentDate = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(new Date());
                String currentTime = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());
                userRecord.setDate(currentDate);
                userRecord.setTime(currentTime);
                if (userRecord != null) {
                    savedata();

                } else {
                    Toast.makeText(SumActivity.this, "null", Toast.LENGTH_LONG).show();

                }
                savedata();
            }
        });


    }

    private void savedata() {
        SaveTask st = new SaveTask();
        st.execute();
    }

    class SaveTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            appDatabase = AppDatabase.getInstance(SumActivity.this);

            appDatabase.recordDao().insert(userRecord);

            //adding to database

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            startActivity(new Intent(SumActivity.this, MainActivity.class));
            finishAffinity();
        }
    }


}



