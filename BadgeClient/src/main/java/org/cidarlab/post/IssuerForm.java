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
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_ISSUER;
import org.cidarlab.dom.LoginCredentials;

/**
 *
 * @author Alex
 */
public class IssuerForm extends LoginCredentials{
    public String name; 
    public String description; 
    public String issuerURL;
    public IssuerForm(String email, String password, String name, String description, String issuerURL) {
        super(email, password);
        this.name = name;
        this.description = description;
        this.issuerURL = issuerURL;
    }

    public boolean post() throws UnirestException, IOException
    {
        if(login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_ISSUER)
                    .field("name", name)
                    .field("description", description)
                    .field("url", issuerURL)
                    .asString();
            return HTMLSearch("Your issuer has been created!", "p", response);
        }
        
        return false;
    }  
}
