package com.example.model;

public class ApiUtils {

    public static final String BASE_USER_URL = "https://user-api-test.herokuapp.com/";

    public static final String BASE_JOB_URL = "https://job-api.herokuapp.com/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_USER_URL).create(UserService.class);
    }

    public static JobService getJobService(){
        return RetrofitClient.getClient(BASE_JOB_URL).create(JobService.class);
    }
}
