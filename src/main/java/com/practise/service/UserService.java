package com.practise.service;

import com.practise.model.User;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService
{

    public ArrayList<User> getUsers(ResultSet rs, ArrayList<User> ul) throws SQLException {

        while(rs.next())
        {
            User u1 = new User(rs.getLong(1),rs.getString(2),rs.getString(3));
            ul.add(u1);

        }
        return   ul;
    }
}
