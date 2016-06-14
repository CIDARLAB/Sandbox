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
public class RepeatTaskForm extends TaskForm{
    public String circuit;
    public String repetitions;

    public RepeatTaskForm(String email, String password, String badge, String user, String app, String circuit, String repetitions) {
        super(email, password, badge, user, app);
        this.circuit = circuit;
        this.repetitions = repetitions;
    } 
    
    public boolean post() throws IOException, MalformedURLException, UnirestException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_TASKS)
                .field("badge", badge)
                .field("user", user)
                .field("app", app)
                .field("repeat", repetitions)
                .field("circuit", circuit)
                .field("flag", "True")
                .field("typeselection", "repeat")
                .asString();
            return HTMLSearch("Your badge was successfully created!", "h2", response);
        }
        return false;
    }
}
