package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao implements AutoCloseable {

private  Connection con;
static PreparedStatement signIn;
static PreparedStatement signUp;
static PreparedStatement editProfile;
static PreparedStatement changePass;

    public UsersDao() throws Exception {
        con=DBUtil.getCon();
        signIn=con.prepareStatement("select * from users where email=? and password = ?");
        signUp=con.prepareStatement("insert into users values(default,?,?,?,?,?,?)");
        editProfile=con.prepareStatement("update users set first_name=?,last_name=?,email=?,password=?,mobile=?,birth=? where id=?");
        changePass=con.prepareStatement("update users set password=? where id=?");

    }
    public static java.sql.Date convertTOsqlDate(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }
    public  void Save(UsersPOJO u) throws SQLException //signup
    {
        signUp.setString(1,u.getFirst_name());
        signUp.setString(2,u.getLast_name());
        signUp.setString(3,u.getEmail());
        signUp.setString(4,u.getPassword());
        signUp.setString(5,u.getMobile());
        signUp.setDate(6,convertTOsqlDate(u.getBirth()));
        signUp.executeUpdate();

    }
    public  UsersPOJO findByMail(UsersPOJO u) throws SQLException//signin
    {
        signIn.setString(1,u.getEmail());
        signIn.setString(2,u.getPassword());
        ResultSet set=signIn.executeQuery();
        if(set.next()) {
            u.setId(set.getInt("id"));
            u.setFirst_name(set.getString("first_name"));
            u.setLast_name(set.getString("last_name"));
            u.setEmail(set.getString("email"));
            u.setMobile(set.getString("mobile"));
            u.setBirth(set.getDate("birth"));
        }
        else{
            return null;
        }
        return u;
    }

    public void Profile(UsersPOJO u) throws SQLException {
        u.accept();
        editProfile.setString(1,u.getFirst_name());
        editProfile.setString(2,u.getLast_name());
        editProfile.setString(3,u.getEmail());
        editProfile.setString(4,u.getPassword());
        editProfile.setString(5,u.getMobile());
        editProfile.setDate(6,convertTOsqlDate(u.getBirth()));
        editProfile.setInt(7,u.getId());
        editProfile.executeUpdate();
    }
    public void PasswordChange(int id,String pass) throws SQLException {
        changePass.setString(1,pass);
        changePass.setInt(2,id);
        changePass.executeUpdate();
    }

    @Override
    public void close() throws Exception {
            con.close();
    }

}
