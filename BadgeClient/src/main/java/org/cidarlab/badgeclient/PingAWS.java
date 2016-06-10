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
import java.net.MalformedURLException;

/**
 *
 * @author david
 */
public class PingAWS {
    
    public static void main(String[] args) throws IOException, MalformedURLException, UnirestException {
        String targetURL = "http://52.39.236.237:8080/";
        String ping = loginAdmin(targetURL);
        
        String[] params = new String[6];
        params[0] = "Test Badge";
        params[1] = "Testing post request for peasantry badge creation";
        params[2] = "Bomberman.png";
        params[3] = "Being the best peasant you can be";
        params[4] = "Tag you're it";
        params[5] = "ME";
        
        String badgePls = createBadge(targetURL, params);
        System.out.println(badgePls);
    }

    public static String loginAdmin(String targetURL) throws MalformedURLException, IOException, UnirestException {
        HttpResponse<String> response = Unirest.post(targetURL + "login")
                .field("email","beepboop@gmail.com")
                .field("password","hello")
                .asString();
        
        HttpResponse<String> myProfile = Unirest.get(targetURL + "myprofile")
                .asString();
        
        String rpString = myProfile.getBody().toString();
        return rpString;
        
    }
    
    public static String createBadge(String targetURL, String[] params) throws UnirestException     
    {
        HttpResponse<String> response = Unirest.post(targetURL+"admin-badge")
                .field("name", params[0])
                .field("description", params[1])
                .field("image", params[2])
                .field("criteria", params[3])
                .field("tags", params[4])
                .field("issuer", params[5])
                .asString();
        
        return response.getBody().toString();
        
    }

}
