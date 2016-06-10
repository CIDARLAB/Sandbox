/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.badgeclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import static org.cidarlab.badgeclient.BadgeEndPoints.*;

/**
 *
 * @author david
 * @author alex
 */
public class HelloWorld {   
    
    public static void main(String args[])  throws UnirestException, IOException{
        System.out.println("Doing stuff!");
    }
    
    // Services: myprofile, logout
    public HttpResponse<String> basicGet(String url, String email, String password) throws UnirestException
    {
        Unirest.post(LOGIN)
                .field("email", email)
                .field("password", password)
                .asString();
        return Unirest.get(url).asString();
    }
    
    //registers a new user with PCR Hero
    public HttpResponse<String> register(String name, String email, String password, String passwordcheck) throws UnirestException
    {
        return Unirest.post(REGISTER)
                .field("name", name)
                .field("email", email)
                .field("password", password)
                .field("passwordcheck", passwordcheck)
                .asString();
    }
}
