package com.sunbeam;

import java.util.Scanner;

public class SharesPOJO {
    private int reviewId;
    private int userId;
    public static Scanner sc=new Scanner(System.in);

    public SharesPOJO(int reviewId, int userId) {
        this.reviewId = reviewId;
        this.userId = userId;
    }
    public SharesPOJO(){}
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public SharesPOJO accept(){
        System.out.println("Enter id of review you want to share");
        this.reviewId=sc.nextInt();
        System.out.println("Enter id of the user you want to share the review");
        this.reviewId=sc.nextInt();
        return this;
    }
}
