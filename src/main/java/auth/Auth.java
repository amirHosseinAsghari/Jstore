package auth;

import dataOp.*;

import java.util.ArrayList;

public class Auth {
    public static void main(String[] args) {

    }
    public static boolean add(String userName, String password){
        ArrayList<String> authData = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/users.txt");
        for (int i = 1; i < authData.size(); i++) {
            String[] userCredential = authData.get(i).split(":");
            if (userCredential[0].equals(userName)){
                System.out.println("User already exists");
                return false;
            }
        }
        String line = userName + ":" + password;
        WriteOp.appendFile("/home/amir/Dev/JJ/src/main/resources/data/users.txt",line);
        return true;
    }
    public static boolean check(String userName, String password){
        ArrayList<String> authData = ReadOp.readFile("/home/amir/Dev/JJ/src/main/resources/data/users.txt");
        for (int i = 1; i < authData.size(); i++) {
            String[] userCredential = authData.get(i).split(":");
            if (userCredential[0].equals(userName) && userCredential[1].equals(password)){
                return true;
            }
        }
        return false;
    }
}
