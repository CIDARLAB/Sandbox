/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.post;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.File;
import java.io.IOException;
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_IMAGES;
import org.cidarlab.dom.LoginCredentials;

/**
 *
 * @author Alex
 */
public class UploadImageForm extends LoginCredentials {
    public File image;

    public UploadImageForm(String email, String password, File image) {
        super(email, password);
        this.image = image;
    }
    
    public  boolean post() throws UnirestException, IOException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_IMAGES)
                    .field("image", image)
                    .asString();
            return HTMLSearch("Image successfully uploaded!", "h2", response);
        }
        return false;   
    }
}
