package com.example.triviaapp.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.R;
import com.example.triviaapp.activities.models.UserRecord;
import com.example.triviaapp.databinding.RecordRowBinding;

import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.CustomViewHolder> {

        private List<UserRecord> dataList;
        private Context context;

        public RcAdapter(Context context, List<UserRecord> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            RecordRowBinding binding;

            CustomViewHolder(RecordRowBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            RecordRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.record_row, parent, false);
            return new CustomViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            holder.binding.tvNameH.setText(dataList.get(position).getName());
            holder.binding.tvAns2H.setText(dataList.get(position).getAone());
            holder.binding.tvAns3H.setText(dataList.get(position).getAtwo());
            holder.binding.gametv.setText("GAME "+Integer.toString(dataList.get(position).getId())+" ");
            holder.binding.datetimetv.setText(dataList.get(position).getDate() + " - "+dataList.get(position).getTime());

           /* holder.binding.title.setText(dataList.get(position).getFirstName() + " " + dataList.get(position).getLastName());
            holder.binding.description.setText(dataList.get(position).getEmail());
*/
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

