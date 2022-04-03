package com.practise.service;

import com.practise.model.User;

import java.util.Arrays;
import java.util.List;

public class UserService
{







    public List<User> getUsers()
    {
        return
                Arrays.asList(new User(001l,"Shivam","Gokarankar","shivamg@unfyd.com")
                ,new User(002l,"Snehal","Desai","snehald@unfyd.com")
                ,new User(003l,"Rahul","Warke","rahulw@unfyd.com"));
    }
}
