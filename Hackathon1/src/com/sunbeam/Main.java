package com.sunbeam;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void loginChoice(){
        LoginMenu[] arrLogin = LoginMenu.values();
        LoginMenu loginChoice = LoginMenu.EXIT;
        do{
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
                    break;
                case Login:
                    break;
                case Signup:
                    break;
                case WrongChoice:
                    System.out.println("Wrong Choice!");
                    break;
            }
        }while(loginChoice != LoginMenu.WrongChoice);
    }

    public static void userChoice(){
        UserMenu[] arrUser = UserMenu.values();
        UserMenu userChoice = UserMenu.Logout;
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
            if(temp < 0 || temp > 9){
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
                    break;
                case ChangePassword:
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
                    break;
                case EditReview:
                    break;
                case DeleteReview:
                    break;
                case DisplayAllReviews:
                    break;
                case DisplayMyReviews:
                    break;
                case DisplaySharedReviews:
                    break;
                case ShareReview:
                    break;
                case WrongChoice:
                    System.out.println("Wrong Choice");
                    break;
            }
        }while(userChoice != UserMenu.Logout);
        loginChoice();
    }
    public static void main(String[] args) {
        userChoice();
    }
}
