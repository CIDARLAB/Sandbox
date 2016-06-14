/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.dom;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.MalformedURLException;
import static org.cidarlab.dom.BadgeEndPoints.LOGIN;

/**
 *
 * @author Alex
 */
public abstract class LoginCredentials extends GetPostSharedMethods{
    
    public String email;
    public String password; 

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    
    /**
     * Login a user so profile dependent requests will work
     * @return true if successful login, otherwise false
     * @throws java.net.MalformedURLException
     * @throws com.mashape.unirest.http.exceptions.UnirestException
     */
    public boolean login() throws MalformedURLException, IOException, UnirestException {
        
        HttpResponse<String> response = Unirest.post(LOGIN)
                .field("email", email)
                .field("password", password)
                .asString();
        
        return HTMLSearch("Welcome back", "h2", response);  
    }
}
