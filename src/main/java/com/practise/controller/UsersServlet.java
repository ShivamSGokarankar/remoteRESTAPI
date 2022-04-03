package com.practise.controller;

import com.dbconnection.DatabaseConnectionMaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logger.LogFileCreator;
import com.practise.model.User;
import com.practise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/getUsers"}, name = "users", description = "Simple servlet to return user data in JSON format")
public class UsersServlet extends HttpServlet {
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
    public final static String connectionString = "jdbc:sqlserver://localhost:1433;databasename=UsersServlet;";
    private UserService service = new UserService();
    public void init() throws ServletException {
        try {
            this.l = new LogFileCreator(logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/JSON");
        response.setCharacterEncoding("UTF-8");
        List<User> users = new ArrayList<>();
        users=service.getUsers();
        Gson data = new GsonBuilder().setPrettyPrinting().create();
        String jsonData= data.toJson(users);
        response.getWriter().write(jsonData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
