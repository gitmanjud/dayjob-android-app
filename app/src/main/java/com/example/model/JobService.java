package com.example.model;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JobService {

   @GET("job")
    Call<JobList> getAllJobs();

    @POST("job")
    Call<JobModel> create(@Body JobModel job);
}
