package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class JobModel {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("fcount")
    @Expose
    private Integer fcount;
    @SerializedName("mcount")
    @Expose
    private Integer mcount;
    @SerializedName("sal")
    @Expose
    private double sal;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("jobLocation")
    @Expose
    private JobLocationModel jobLocation;
    @SerializedName("jobId")
    @Expose
    private String jobId;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("userId")
    @Expose
    private String userId;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getFcount() {
        return fcount;
    }
    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }
    public Integer getMcount() {
        return mcount;
    }
    public void setMcount(Integer mcount) {
        this.mcount = mcount;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }
    public JobLocationModel getJobLocation() {
        return jobLocation;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setJobLocation(JobLocationModel jobLocation) {
        this.jobLocation = jobLocation;
    }
    @Override
    public String toString() {
        return "JobModel [id=" + id + ", mobileNo=" + mobileNo + ", desc=" + desc + ", fcount=" + fcount + ", mcount="
                + mcount + ", sal=" + sal + ", created=" + created + ", updated=" + updated + ", jobLocation="
                + jobLocation + ", jobId=" + jobId + ", startTime=" + startTime + ", endTime=" + endTime + ", date="
                + date + ", active=" + active + ", userId=" + userId + "]";
    }

}
