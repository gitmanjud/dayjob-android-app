package com.example.testproject2;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.model.JobViewModel;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class JobListBaseAdapter   extends RecyclerView.Adapter<JobListBaseAdapter.ViewHolder>{

    private static List<JobViewModel> jobViewModels;

    private LayoutInflater mInflater;
    private Context mContext;

    public JobListBaseAdapter(Context context,List<JobViewModel> list)
    {mContext = context;
        this.jobViewModels = list;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.job_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder myViewHolder, int i) {
        JobViewModel movie = jobViewModels .get(i);

        myViewHolder.jobDesc.setText(movie.getJobDesc());
        myViewHolder.jobLoc.setText(movie.getJobLocation());


        final JobViewModel myListData = jobViewModels.get(i);
        myViewHolder.jobDesc.setText(myListData.getJobDesc());

        myViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, JobDetailsActivity.class);
                intent.putExtra("image_url", myListData.getJobDesc());
                intent.putExtra("image_name", myListData.getMobileNo());
                mContext.startActivity(intent);

                Toast.makeText(view.getContext(),"click on item: "+myListData.getJobDesc(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobViewModels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView jobDesc, jobLoc;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            jobDesc = (TextView) itemView.findViewById(R.id.jobDesc);
            jobLoc = (TextView) itemView.findViewById(R.id.jobLoc);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.jlist);
        }
    }
}
