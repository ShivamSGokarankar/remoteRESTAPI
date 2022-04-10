package com.practise.controller;

import com.dbconnection.DatabaseConnectionMaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.logger.LogFileCreator;
import com.practise.model.User;
import com.practise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======

>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
import javax.print.attribute.standard.JobOriginatingUserName;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
@WebServlet(urlPatterns = "/api/*", name = "ControllerServlet", description = "Simple servlet to return data from db in JSON format")
=======
@WebServlet(urlPatterns = "/api", name = "ControllerServlet", description = "Simple servlet to return data from db in JSON format")
>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
public class ControllerServlet extends HttpServlet {
    static LogFileCreator l;
    String errormsg = "";
    public PrintWriter out;
    private static Connection connection;
    public static String logFilePath = "D:\\Logs";
    public boolean IsDbConnected = true;
    DatabaseConnectionMaker dbconnnmaker;
    private static final String dbusername = "sa";
    private static final String dbpassword = "Admin@123";
    public final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String connectionString = "jdbc:sqlserver://localhost:1433;databasename=Users;";

<<<<<<< HEAD
    public void init() throws ServletException
    {
=======
    public void init() throws ServletException {
>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
        try {
            this.l = new LogFileCreator(logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
=======


>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
        this.dbconnnmaker = new DatabaseConnectionMaker(dbusername, dbpassword,Driver, connectionString);
        try {
            connection = dbconnnmaker.dbConnectionCheck();
            l.WriteLog("Database connected succesffully.");
        } catch (ClassNotFoundException e) {
            l.WriteLog("Driver loading failed.\n" + e.getMessage());
        } catch (
                SQLException e) {
            l.WriteLog("Database connection failed.\n" + e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String servletPath1= request.getServletPath();
<<<<<<< HEAD
        String servletpath2 =request.getPathInfo();

        switch (servletpath2)
=======

        switch (servletPath1)
>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
        {
            case "/getUsers":
                getUsers(request,response);
                break;
            case "/getProducts":
                getProducts(request,response);
                break;
        }

    }
<<<<<<< HEAD
=======



>>>>>>> 14f9168147178dfafe8d3d089928ad85815342d4
    private void getUsers(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ArrayList<User> userList=new ArrayList<User>();
        try(Statement statement = connection.createStatement())
        {
            try(ResultSet rs = statement.executeQuery("select id,username,password from usermaster"))
            {
                if(rs.next())
                {
                    userList=new UserService().getUsers(rs,userList);
                }
            }

        } catch (SQLException throwables) {
            l.WriteLog("Error Occured while creating statement");
        }
        finally {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson data= new GsonBuilder().setPrettyPrinting().create();
            String jsonData= data.toJson(userList);
            response.getWriter().write(jsonData);
        }
    }
    private void getProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<User> productList=new ArrayList<User>();
        try(Statement statement = connection.createStatement())
        {
            try(ResultSet rs = statement.executeQuery("select * from ProductMaster"))
            {
                if(rs.next())
                {
                    productList=new UserService().getUsers(rs,productList);
                }
            }

        } catch (SQLException throwables) {
            l.WriteLog("Error Occured while creating statement");
        }
        finally {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson data= new GsonBuilder().setPrettyPrinting().create();
            String jsonData= data.toJson(productList);
            response.getWriter().write(jsonData);
        }
    }



}
