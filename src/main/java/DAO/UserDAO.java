package DAO;

import config.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {


    public static boolean checkUserExists(String nick, String pwd)  {
    try {


    Connection con = DBConnection.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(" select count(*) as poc from users WHERE ( users.nickname = '" + nick + "' AND users.password = '" + pwd+"')");

    rs.next();
    if (!(rs.getString("poc").equals("0")) ){
        System.out.println(rs.getString("poc") + " true");

        return true;
    }
    else {
        System.out.println(rs.getString("poc" + " false"));

        return false;
    }
    } catch (SQLException e) {
    e.printStackTrace();
    return false;
    }
    }
}