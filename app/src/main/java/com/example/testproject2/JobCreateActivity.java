package com.example.testproject2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.model.ApiUtils;
import com.example.model.JobLocationModel;
import com.example.model.JobModel;
import com.example.model.JobService;
import com.example.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobCreateActivity  extends AppCompatActivity {

    JobService jobService;
    Button jobCreateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_create);
        jobCreateButton = (Button) findViewById(R.id.jobSumbmit);

        jobCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText  jdesc = (EditText) findViewById(R.id.jdesc);
                EditText fcount = (EditText) findViewById(R.id.fcount);
                EditText mcount = (EditText) findViewById(R.id.mcount);
                EditText salary = (EditText) findViewById(R.id.salary);
                EditText startTime = (EditText) findViewById(R.id.startTime);
                EditText endTime = (EditText) findViewById(R.id.endTime);
                EditText date = (EditText) findViewById(R.id.date);
                EditText country = (EditText) findViewById(R.id.country);
                EditText  state = (EditText) findViewById(R.id.state);
                EditText dist = (EditText) findViewById(R.id.dist);
                EditText tq = (EditText) findViewById(R.id.tq);
                EditText region = (EditText) findViewById(R.id.region);
                EditText locDesc = (EditText) findViewById(R.id.locDesc);

                JobModel jobModel = new JobModel();
                jobModel.setDesc(jdesc.getText().toString());
                jobModel.setFcount(fcount.getText().toString() != null? Integer.parseInt(fcount.getText().toString()) : 0);
                jobModel.setMcount(mcount.getText().toString() != null? Integer.parseInt(mcount.getText().toString()) : 0);
                jobModel.setSal(salary.getText().toString() != null? Integer.parseInt(salary.getText().toString()) : 0);
                jobModel.setStartTime(startTime.getText().toString());
                jobModel.setEndTime(endTime.getText().toString());
                jobModel.setDate(date.getText().toString());

                JobLocationModel jobLocation  = new JobLocationModel();
                jobLocation.setCountry(country.getText().toString());
                jobLocation.setState(state.getText().toString());
                jobLocation.setDist(dist.getText().toString());
                jobLocation.setTq(tq.getText().toString());
                jobLocation.setRegion(region.getText().toString());
                jobLocation.setLocDesc(locDesc.getText().toString());

                jobModel.setJobLocation(jobLocation);


                createJob(jobModel);

                Call call = jobService.create(jobModel);



  //              createJob(userModel);

            }
        });

    }



    private void createJob(final JobModel jobModel){
        jobService = ApiUtils.getJobService();
        Call call = jobService.create(jobModel);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    JobModel newJobModel = (JobModel)response.body();
                    if(newJobModel.getId() != null){
                        //login start main activity
                        Toast.makeText(JobCreateActivity.this, newJobModel.getId() , Toast.LENGTH_LONG).show();
                     //   Intent intent = new Intent(RegistrationActivity.this, JobActivity.class);
                       // startActivity(intent);

                    }
                } else {
                    Toast toast=   Toast.makeText(JobCreateActivity.this ,"something wrong please try again!",Toast.LENGTH_LONG);
                    View view =toast.getView();
                    view.setBackgroundColor(Color.RED);
                    toast.show();

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(JobCreateActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
