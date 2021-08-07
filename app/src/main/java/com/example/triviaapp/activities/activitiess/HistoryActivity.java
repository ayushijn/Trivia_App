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
import com.example.triviaapp.activities.adapters.RcAdapter;
import com.example.triviaapp.activities.databases.AppDatabase;
import com.example.triviaapp.activities.models.UserRecord;
import com.example.triviaapp.databinding.ActivityMainBinding;
import com.example.triviaapp.databinding.HistoryActivityBinding;

import java.util.List;

public class HistoryActivity extends Activity {
    private HistoryActivityBinding binding;
    RcAdapter adapter;
    private List<UserRecord> userRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.history_activity);

        getHistory();

        setListener();
    }

    /*
     *
     * set click listeners
     * */
    private void setListener() {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    /*
     *
     * getting history data from db
     * */
    private void getHistory() {
        GetHistory gt = new GetHistory();
        gt.execute();
    }

    class GetHistory extends AsyncTask<Void, Void, List<UserRecord>> {

        @Override
        protected List<UserRecord> doInBackground(Void... voids) {
            List<UserRecord> historyList = AppDatabase
                    .getInstance(HistoryActivity.this)
                    .recordDao()
                    .getAll();
            return historyList;
        }

        @Override
        protected void onPostExecute(List<UserRecord> records) {
            super.onPostExecute(records);
            if (records != null) {
                adapter = new RcAdapter(HistoryActivity.this, records);
                binding.rcView.setAdapter(adapter);
            } else
                Toast.makeText(HistoryActivity.this, "Data not available", Toast.LENGTH_SHORT).show();
        }

    }


}
