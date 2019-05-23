package com.farshadfard.helloworldsematec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder> {

    private ArrayList<String> cityList;
    private OnItemClickListener clickListener;

    SearchHistoryAdapter(ArrayList<String> list, OnItemClickListener clickListener) {
        this.cityList = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SearchHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_history_item, parent, false);
        return new SearchHistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHistoryViewHolder holder, int position) {
        holder.txtCityName.setText(cityList.get(position));
    }


    @Override
    public int getItemCount() {
        return cityList.size();
    }

    class SearchHistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtCityName;

        public SearchHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCityName = itemView.findViewById(R.id.txtCityName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null)
                clickListener.onClick(txtCityName.getText().toString());
        }
    }
}
