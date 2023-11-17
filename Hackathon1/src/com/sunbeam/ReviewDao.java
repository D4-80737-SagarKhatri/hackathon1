package com.sunbeam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        stmtEditReview = con.prepareStatement("Update reviews set review = ? ,rating = ?, modified = now() where id = ? and user_id = ?");
        stmtDeleteReview = con.prepareStatement("Delete from reviews where id = ? and user_id = ?");
        stmtDisplayAllReview = con.prepareStatement("Select * from reviews");
        stmtDisplayMyReviews = con.prepareStatement("select * from reviews where user_id = ?");
    }



//    Insert into reviews values(default, ?,?,?,?,?)
    public void createReview(ReviewsPOJO r) throws Exception{
        stmtCreateReview.setInt(1, r.getMovie_id());
        stmtCreateReview.setString(2, r.getReview());
        stmtCreateReview.setInt(3, r.getRating());
        stmtCreateReview.setInt(4, r.getUser_id());
        stmtCreateReview.setTimestamp(5, r.getModified());
        stmtCreateReview.executeUpdate();
    }

    public void editReview(int id,int rating,String review ,int uid) throws SQLException {
        stmtEditReview.setString(1,review);
        stmtEditReview.setInt(2,rating);
        stmtEditReview.setInt(3,id);
        stmtEditReview.setInt(4,uid);
        stmtEditReview.executeUpdate();
    }


    public void deleteReview(int id, int uid) throws Exception{
        stmtDeleteReview.setInt(1, id);
        stmtDeleteReview.setInt(2, uid);
        stmtDeleteReview.executeUpdate();
        String str = "delete from shares where review_id = " + id;
        PreparedStatement temp = con.prepareStatement(str);
        temp.executeUpdate();
    }


    public List<ReviewsPOJO> displayAllReviews() throws Exception{
        ResultSet rs = stmtDisplayAllReview.executeQuery();
        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
        while(rs.next()){
            ReviewsPOJO temp = new ReviewsPOJO();
            temp.setId(rs.getInt("id"));
            temp.setMovie_id(rs.getInt("movie_id"));
            temp.setReview(rs.getString("review"));
            temp.setUser_id(rs.getInt("user_id"));
            temp.setModified(rs.getTimestamp("modified"));
            temp.setRating(rs.getInt("rating"));
            reviewsPOJOList.add(temp);
        }
        return reviewsPOJOList;
    }


    public List<ReviewsPOJO> displayMyReviews(int id) throws Exception{
        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
        stmtDisplayMyReviews.setInt(1, id);
        ResultSet rs = stmtDisplayMyReviews.executeQuery();
        while(rs.next()){
            ReviewsPOJO temp = new ReviewsPOJO();
            temp.setId(rs.getInt("id"));
            temp.setMovie_id(rs.getInt("movie_id"));
            temp.setReview(rs.getString("review"));
            temp.setUser_id(rs.getInt("user_id"));
            temp.setModified(rs.getTimestamp("modified"));
            reviewsPOJOList.add(temp);
        }
        return reviewsPOJOList;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }
}
