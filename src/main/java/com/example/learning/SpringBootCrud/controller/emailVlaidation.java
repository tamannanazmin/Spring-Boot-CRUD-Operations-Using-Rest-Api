package com.example.learning.SpringBootCrud.controller;

import java.util.regex.Pattern;

public class emailVlaidation
{
    public static void main(String[] args){
        String email = "tamanna.naz98@gamil.com";
        System.out.println("the email is: "+validateEmail(email));
    }
    public static String validateEmail(String email){
        if(email == null || email.isEmpty()){
            return "Invalid Email. Please Try again";
        }
        String emailRegex = "[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(email).matches()){
            return "Valid";
        }else {
            return "Invalid";
        }
    }

}
