package com.practise.model;

public class User
{
    private long userid;
    private String firstName;
    private String lastName;
    private String emailid;

    public User(long userid, String firstName, String lastName, String emailid) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailid = emailid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
