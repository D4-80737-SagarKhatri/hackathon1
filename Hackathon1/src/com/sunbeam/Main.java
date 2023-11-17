package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void loginChoice(){
        LoginMenu[] arrLogin = LoginMenu.values();
        LoginMenu loginChoice = LoginMenu.EXIT;
        do{
            UsersPOJO user;
            System.out.println("0. EXIT");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.print("Enter Choice: ");
            int temp = sc.nextInt();
            if(temp < 0 || temp > 2){
                loginChoice = LoginMenu.WrongChoice;
            }
            else{
                loginChoice = arrLogin[temp];
            }
            switch (loginChoice){
                case EXIT:
                    System.out.println("Exiting......");
                    System.exit(0);
                    break;
                case Login:
                    try(UsersDao dao = new UsersDao()){
                        user = new UsersPOJO();
                        System.out.println("Enter Your Email: ");
                        user.setEmail(sc.next());
                        System.out.println("Enter Password: ");
                        user.setPassword(sc.next());
                        user = dao.findByMail(user);
                        if(user == null){
                            System.out.println("User Not Found...");
                        }
                        else{
                            userChoice(user);
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case Signup:
                    try(UsersDao dao = new UsersDao()){
                        UsersPOJO u = new UsersPOJO().accept();
                        dao.Save(u);
                        System.out.println("User Added");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case WrongChoice:
                    System.out.println("Wrong Choice!");
                    break;
            }
        }while(loginChoice != LoginMenu.WrongChoice || loginChoice != LoginMenu.EXIT);
    }

    public static void userChoice(UsersPOJO u){
        UserMenu[] arrUser = UserMenu.values();
        UserMenu userChoice = UserMenu.Logout;
        List<ReviewsPOJO> list = new ArrayList<>();
        do{
            System.out.println("0. Logout");
            System.out.println("1. Edit Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Display All Movies");
            System.out.println("4. Create Review");
            System.out.println("5. Edit Review");
            System.out.println("6. Delete Review");
            System.out.println("7. Display All Reviews");
            System.out.println("8. Display My Reviews");
            System.out.println("9. Display Shared Reviews");
            System.out.println("10. Share a Review");
            System.out.print("Enter Choice: ");
            int temp = sc.nextInt();
            if(temp < 0 || temp > 10){
                userChoice = UserMenu.WrongChoice;
            }
            else{
                userChoice = arrUser[temp];
            }
            switch (userChoice){
                case Logout:
                    System.out.println("Logging out.....");
                    break;
                case EditProfile:
                    try(UsersDao dao = new UsersDao()){
                        dao.Profile(u);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case ChangePassword:
                    try(UsersDao dao = new UsersDao()){
                        System.out.println("Enter New Password");
                        dao.PasswordChange(u.getId(), sc.next());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case DisplayAllMovies:
                    try(MoviesDao dao = new MoviesDao()){
                        List<MoviesPOJO> moviesPOJOList = dao.diplayAllMovies();
                        System.out.println(moviesPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case CreateReview:
                    try(MoviesDao dao = new MoviesDao()){
                        List<MoviesPOJO> moviesPOJOList = dao.diplayAllMovies();
                        System.out.println(moviesPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Which Movie's Review Do you want to Create?: ");
                    try(ReviewDao dao = new ReviewDao()){
                        dao.createReview(new ReviewsPOJO().accept().setUser_id(u.getId()));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case EditReview:
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayMyReviews(u.getId());
                        System.out.println(reviewsPOJOList.toString());
                        System.out.println("Select The id of review that you want to edit: ");
                        int id=sc.nextInt();
                        System.out.println("Enter rating ");
                        int rating=sc.nextInt();
                        System.out.println("Enter review");
                        sc.nextLine();
                        String review=sc.nextLine();
                        dao.editReview(id,rating,review, u.getId());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case DeleteReview:
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayMyReviews(u.getId());
                        System.out.println(reviewsPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayMyReviews(u.getId());
                        System.out.println(reviewsPOJOList.toString());
                        System.out.println("Select The id of review that you want to delete: ");
                        dao.deleteReview(sc.nextInt(), u.getId());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case DisplayAllReviews:
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayAllReviews();
                        System.out.println(reviewsPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case DisplayMyReviews:
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayMyReviews(u.getId());
                        System.out.println(reviewsPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case DisplaySharedReviews:
                    try(ShareDao dao=new ShareDao()){
                        list=dao.DisplayReviewsSharedWithMe(u.getId());
                        System.out.println(list.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case ShareReview:
                    try(ReviewDao dao = new ReviewDao()){
                        List<ReviewsPOJO> reviewsPOJOList = new ArrayList<>();
                        reviewsPOJOList = dao.displayMyReviews(u.getId());
                        System.out.println(reviewsPOJOList.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    try(ShareDao dao=new ShareDao()){
                        dao.shareReview(new SharesPOJO().accept());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case WrongChoice:
                    System.out.println("Wrong Choice");
                    break;
            }
        }while(userChoice != UserMenu.Logout);
        loginChoice();
    }
    public static void main(String[] args) {
        loginChoice();
    }
}
