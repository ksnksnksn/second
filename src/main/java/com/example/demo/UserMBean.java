package com.example.demo;



public interface UserMBean {

    public void printUserInfo();


    public Long getId();

    public String getUserName();
    public void setUserName(String userName);

    public String getPassword();
    public void setPassword(String password);

}
