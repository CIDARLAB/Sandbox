/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.post;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import org.cidarlab.dom.LoginCredentials;

/**
 *
 * @author Alex
 */
public class AwardBadgeForm extends LoginCredentials {
    
    public String targetURL; 
    public String user;
    public String badge;
    
    public AwardBadgeForm(String email, String password, String targetURL, String user, String badge) {
        super(email, password);
        this.targetURL = targetURL;
        this.user = user;
        this.badge = badge;
    }
    
    public boolean post() throws UnirestException, IOException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(targetURL + "admin-awards")
                    .field("user", user)
                    .field("badge", badge)
                    .asString();
            return HTMLSearch("Badge successfully awarded!","h2",response);
        }
        return false;
    }
}
