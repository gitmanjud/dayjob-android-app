package com.example.testproject2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.model.ApiUtils;
import com.example.model.JobList;
import com.example.model.JobModel;
import com.example.model.JobService;
import com.example.model.JobViewModel;
import com.example.model.ResObj;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobActivity  extends AppCompatActivity {

    private ListView mListView;
    JobService jobService;
    private JobListBaseAdapter jobListBaseAdapter;
    private Toolbar bar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobs_list);
        jobService = ApiUtils.getJobService();
        Call call = jobService.getAllJobs();
        bar = findViewById(R.id.toolbar);
        setSupportActionBar(bar);


        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    JobList jobs = (JobList) response.body();
                    List<String> jobId = new ArrayList<>();
                    List<JobViewModel> jobViewModels = new ArrayList<>();
                    if (jobs != null && jobs.getJobs() != null) {

                        for (JobModel jobModel : jobs.getJobs()) {
                            jobId.add(jobModel.getId());

                            JobViewModel model = new JobViewModel();
                            model.setJobDesc(jobModel.getDesc());
                            model.setJobLocation(jobModel.getJobLocation() != null ?
                                    (jobModel.getJobLocation().getCountry() + " " + jobModel.getJobLocation().getState() + " " +
                                            jobModel.getJobLocation().getDist() + " " +
                                            jobModel.getJobLocation().getTq() + " " + jobModel.getJobLocation().getRegion() + " " +
                                            jobModel.getJobLocation().getLocDesc()) : null
                            );
                            jobViewModels.add(model);
                        }

                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
                        jobListBaseAdapter = new JobListBaseAdapter(JobActivity.this,jobViewModels);

                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(JobActivity.this));
                        recyclerView.setAdapter(jobListBaseAdapter);

                    }
                } else {
                    Toast toast = Toast.makeText(JobActivity.this, "Unable to load jobs,Please Try again after some time!", Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.RED);
                    toast.show();

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(JobActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.appmenu, menu);


        MenuItem.OnActionExpandListener ml = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                Toast.makeText(JobActivity.this, "searchdajads", Toast.LENGTH_LONG).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(JobActivity.this, "searchdajads", Toast.LENGTH_LONG).show();
                return true;
            }
        };


        MenuItem it = menu.findItem(R.id.searchId);
        it.setOnActionExpandListener(ml);


        return true;
    }

}
