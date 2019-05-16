package com.example.bakingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bakingapp.models.Step;

import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.AdapterHolder> {
    public List<Step> step;

    public void setStepData(List<Step> data) {
        this.step = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StepAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.step_list_item, viewGroup, false);
        return new StepAdapter.AdapterHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdapter.AdapterHolder adapterHolder, int i) {
        adapterHolder.bind(step.get(i).shortDescription);

    }

    @Override
    public int getItemCount() {
        return step == null ? 0 : step.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;

        public AdapterHolder(@NonNull final View itemView) {
            super(itemView);
            descriptionTextView = itemView.findViewById(R.id.descriptionText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent=new Intent(v.getContext(),StepActivity.class);
                    Step stepKey=step.get(getAdapterPosition());
                    myIntent.putExtra(IntentConstants.CAKE_DESCRIPTION,stepKey);
                    v.getContext().startActivity(myIntent);
                }
            });
        }

        public void bind(final String shortDescriptionText) {
            descriptionTextView.setText(shortDescriptionText);
        }
    }
}
