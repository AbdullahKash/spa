/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx;

import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javax.swing.text.View;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class Student {

    public static ArrayList<String> user = new ArrayList<String>();
    public static ArrayList<String> pass = new ArrayList<String>();

    private Connection connect() throws SQLException {
        //System.out.println("hi");
        Connection con;
        String url = "jdbc:sqlite:C:/Users/sayg9/OneDrive/Documents/NetBeansProjects/ExaJavaFx/DataBaes/db.db";
        con = DriverManager.getConnection(url);
        System.out.println("The Connection established");
        return con;
    }

    public void AddStudent(String Name, String Email, String Mobile, String Address) throws SQLException {
        //   user.add(username);
        //  pass.add(password);
        String sql = "INSERT INTO Student(Name, Email , Mobile , Address) VALUES('" + Name + " ','" + Email + "' , '" + Mobile + " ','" + Address + "' )";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.commit();
        con.close();
        System.out.println("User Created Successfully");
    }

    public void AddCourse(String Name, String Code, String Credit, String Department) throws SQLException {
        String sql = "INSERT INTO Course(Name, Code , Credit , Department) VALUES('" + Name + " ','" + Code + "' , '" + Credit + " ','" + Department + "' )";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.commit();
        con.close();
    }

    public void AddUsers(String username, String password) throws SQLException {
        String sql = "INSERT INTO Users(UserName,Password) VALUES('" + username + " ','" + password + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.commit();
        con.close();
    }

    public void AddCourseRegister(int Idstudent, int Idcourse) throws SQLException {
        String sql = "INSERT INTO CourseReg(StdId, CourseId ) VALUES('" + Idstudent + " ','" + Idcourse + "' )";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }

    public boolean CheckUser(String username, String password) {
        //        if (user.contains(username) && pass.contains(password)) {
        //            return true;
        //        } else {
        //            return false;
        //        }

        boolean t = false;
        String sql = "SELECT UserName, Password FROM Users";
        try {
            Connection con = this.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("UserName");
                String pass = rs.getString("Password");
                if (username.contains(name) && password.contains(pass)) {
                    System.out.println(rs.getString("Name"));
                    t = true;
                    break;
                } else {
                    t = false;
                }
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public ArrayList<String> getUser() {
        return user;
    }

    public ArrayList<String> getPass() {
        return pass;
    }
// for table
    public String getPassword(String users) {
        int ui = user.indexOf(users);
        return pass.get(ui);
    }

// for table
    public void EditStudents(String username, String password) throws SQLException {
        //Edit the data to Database
        String sql = "UPDATE Users SET UserName = '" + username + "', Password = '" + password + "'WHERE UserName = '" + username + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        //con.commit();
        con.close();
        System.out.println("User Updated Successfully");
    }
// for insert the username and password .. for table
    public ResultSet SearchStudents(String user) throws SQLException {
        String sql = "SELECT UserName, Password FROM Users WHERE UserName LIKE '" + user + "%'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet SelectRegisterCuorse () throws SQLException {
        String sql = "SELECT StdId, CourseId FROM CourseReg ";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
}
