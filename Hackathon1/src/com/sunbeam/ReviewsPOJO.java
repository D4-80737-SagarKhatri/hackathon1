package com.sunbeam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class ReviewsPOJO {
    public static Scanner sc = new Scanner(System.in);
    private int id;
    private int movie_id;
    private String review;
    private int rating;
    private int user_id;
    private Timestamp modified;

    public ReviewsPOJO() {
    }

    public ReviewsPOJO(int id, int movie_id, String review, int rating, int user_id, Timestamp modified) {
        this.id = id;
        this.movie_id = movie_id;
        this.review = review;
        this.rating = rating;
        this.user_id = user_id;
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public ReviewsPOJO setId(int id) {
        this.id = id;
        return this;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public ReviewsPOJO setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewsPOJO that = (ReviewsPOJO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", user_id=" + user_id +
                ", modified=" + modified +
                "}\n";
    }

    public ReviewsPOJO accept(){
        System.out.println("Enter Movie ID:");
        this.setMovie_id(sc.nextInt());
        System.out.println("Enter Review: ");
        sc.nextLine();
        this.setReview(sc.nextLine());
        if(review.trim().length() == 0){
            throw new RuntimeException("Review Can't be Empty");
        }
        System.out.println("Enter Rating: ");
        this.setRating(sc.nextInt());
        this.setModified(new Timestamp(System.currentTimeMillis()));
        return this;
    }
}