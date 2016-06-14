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
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_BADGE;
import org.cidarlab.dom.LoginCredentials;

/**
 *
 * @author Alex
 */
public class BadgeForm extends LoginCredentials{
    public String name;
    public String description;
    public String image;
    public String criteria; 
    public String tags;
    public String issuer;
    
    public BadgeForm(String email, String password, String name, String description, String image, String criteria, String tags, String issuer) {
        super(email, password);
        this.name = name;
        this.description = description;
        this.image = image;
        this.criteria = criteria;
        this.tags = tags;
        this.issuer = issuer;
    }
    
    public boolean post() throws UnirestException, IOException {
        if(login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_BADGE)
                    .field("name", name)
                    .field("description", description)
                    .field("image", image)
                    .field("criteria", criteria)
                    .field("tags", tags)
                    .field("issuer", issuer)
                    .asString();
            
            return HTMLSearch("Your badge was successfully created!", "h2", response);
        }
        return false;
    }
}
