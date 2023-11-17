package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReviewDao implements AutoCloseable{
    private Connection con;
    private PreparedStatement stmtCreateReview;
    private PreparedStatement stmtEditReview;
    private PreparedStatement stmtDeleteReview;
    private PreparedStatement stmtDisplayAllReview;
    private PreparedStatement stmtDisplayMyReviews;

    public ReviewDao() throws Exception{
        con = DBUtil.getCon();

        stmtCreateReview = con.
                prepareStatement("Insert into reviews values(default, ?,?,?,?,?)");
        stmtEditReview = con.prepareStatement("Update reviews set review = ? rating = ? modified = now()");
        stmtDeleteReview = con.prepareStatement("Delete reviews where id = ?");
        stmtDisplayAllReview = con.prepareStatement("Select * from reviews");
        stmtDisplayMyReviews = con.prepareStatement("select * from reviews where user_ id = ?");
    }

    public int createReview(ReviewsPOJO r) throws Exception{
        stmtCreateReview.setInt(1, r.getMovie_id());
        stmtCreateReview.setString(2, r.getReview());
        stmtCreateReview.setInt(3, r.getRating());
        stmtCreateReview.setInt(4, r.getUser_id());
        stmtCreateReview.setTimestamp(5, r.getModified());
        return stmtCreateReview.executeUpdate();
    }

    public void editReview(){

    }


    public void deleteReview(){}


    public void displayAllReviews(){}


    public void displayMyReviews(){}

    @Override
    public void close() throws Exception {
        con.close();
    }
}
