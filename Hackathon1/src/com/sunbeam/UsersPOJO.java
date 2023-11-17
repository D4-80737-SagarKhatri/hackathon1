package com.sunbeam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class UsersPOJO {
    public static Scanner sc = new Scanner(System.in);
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String mobile;
    private java.util.Date birth;

    public UsersPOJO() {
    }

    public UsersPOJO(int id, String first_name, String last_name, String email, String password, String mobile, Date birth) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.birth = birth;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersPOJO usersPOJO = (UsersPOJO) o;
        return id == usersPOJO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birth=" + birth +
                "}\n";
    }

    public UsersPOJO accept() {

        System.out.println("Enter First Name");
        this.setFirst_name(sc.next());
        System.out.println("Enter Last Name");
        this.setLast_name(sc.next());
        System.out.println("Enter Email");
        this.setEmail(sc.next());
        System.out.println("Enter Password");
        this.setPassword(sc.next());
        System.out.println("Enter Mobile Number");
        this.setMobile(sc.next());
        System.out.println("Enter Birth Date");
        String strDate = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            this.setBirth(sdf.parse(strDate));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }
}
