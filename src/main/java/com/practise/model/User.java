package com.practise.model;

public class User
{
    private long userid;
    private String username;
    private String password;


    public User(long userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
