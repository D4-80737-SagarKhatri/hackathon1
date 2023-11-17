package com.sunbeam;
import com.sunbeam.DBUtil;
import com.sunbeam.ReviewsPOJO;
import com.sunbeam.SharesPOJO;
import com.sunbeam.UsersPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShareDao implements AutoCloseable{
    private Connection con;
    static PreparedStatement displaySharedWithMe;
    static PreparedStatement shareReview;


    public ShareDao() throws Exception {
        con= DBUtil.getCon();
        displaySharedWithMe=con.prepareStatement("select * from reviews where id=ANY(select review_id from shares where user_id=?)");
        shareReview=con.prepareStatement("insert into shares values(?,?)");
    }

    public ArrayList<ReviewsPOJO> DisplayReviewsSharedWithMe(int id) throws SQLException
    {
        ArrayList<ReviewsPOJO> arr=new ArrayList<>();
        displaySharedWithMe.setInt(1,id);
       ResultSet set= displaySharedWithMe.executeQuery();
       while (set.next()){
           ReviewsPOJO r=new ReviewsPOJO();
           r.setId(set.getInt("id"));
           r.setMovie_id(set.getInt("movie_id"));
           r.setReview(set.getString("review"));
           r.setRating(set.getInt("rating"));
           r.setUser_id(set.getInt("user_id"));
           r.setModified(set.getTimestamp("modified"));
           arr.add(r);
       }
       return arr;
    }

    public void shareReview(SharesPOJO s) throws SQLException {
        shareReview.setInt(1,s.getReviewId());
        shareReview.setInt(2,s.getUserId());
        shareReview.executeUpdate();
    }

    @Override
    public void close() throws Exception {
            con.close();
    }
}
