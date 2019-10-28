package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobList {

    @SerializedName("jobs")
    @Expose
    List<JobModel> jobs;

    public List<JobModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobModel> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "JobList{" +
                "jobs=" + jobs +
                '}';
    }
}
