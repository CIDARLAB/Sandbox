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
import java.net.MalformedURLException;
import org.cidarlab.dom.TaskForm;
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_TASKS;

/**
 *
 * @author Alex
 */
public class UniqueTaskForm extends TaskForm{
    public String unique;

    public UniqueTaskForm(String email, String password, String badge, String user, String app, String unique) {
        super(email, password, badge, user, app);
        this.unique = unique;
    }
    
    public boolean post() throws IOException, MalformedURLException, UnirestException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_TASKS)
                .field("badge", badge)
                .field("user", user)
                .field("app", app)
                .field("unique", unique)
                .field("flag", "True")
                .field("typeselection", "unique")
                .asString();
            return HTMLSearch("Your badge was successfully created!", "h2", response);
        }
        return false;
    }
}
