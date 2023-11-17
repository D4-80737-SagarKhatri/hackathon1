package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao implements AutoCloseable{
    private Connection con;
    private PreparedStatement stmtDisplayAllMovies;
    public MoviesDao() throws Exception{
        con = DBUtil.getCon();
        stmtDisplayAllMovies = con.prepareStatement("SELECT * FROM movies");
    }

    public List<MoviesPOJO> diplayAllMovies() throws Exception{
        List<MoviesPOJO> moviesPOJOList = new ArrayList<>();
        ResultSet rs = stmtDisplayAllMovies.executeQuery();
        while(rs.next()){
            MoviesPOJO temp = new MoviesPOJO();
            temp.setId(rs.getInt("id"));
            temp.setTitle(rs.getString("title"));
            temp.setReleased(rs.getDate("releaseD"));
            moviesPOJOList.add(temp);
        }
        return moviesPOJOList;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }
}
