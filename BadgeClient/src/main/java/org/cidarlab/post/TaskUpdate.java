/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.post;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.cidarlab.dom.GetPostSharedMethods;
import org.cidarlab.dom.BadgeEndPoints;

/**
 *
 * @author david
 */
public class TaskUpdate {

    //Who is making progress and on what task?
    public String user;
    public String app;
    public String circuit;
    public double score;
    public double cost;
    
    
    //Create update object
    public TaskUpdate(String user, String app, String circuit, double score, double cost)
    {
        this.user = user;
        this.app = app;
        this.circuit = circuit;
        this.score = score;
        this.cost = cost;
    }

    //Submit update object after you've filled it in.
    public boolean submit() throws UnirestException {

        HttpResponse<String> response = Unirest.post(BadgeEndPoints.SUBMIT)
                .field("user", user)
                .field("app", app)
                .field("circuit", circuit)
                .field("score", Double.toString(score))
                .field("cost", Double.toString(cost))
                .asString();
        
        /*
        ___SUBMIT___
        You get an empty string if it successfully reached the database.
        THAT MEANS:
        
        It's possible that nothing could have updated.
        It's possible that something could have updated.
        
        You need to make sure that the user, app, and circuit all match a task. if they do not correctly match the task fields, then your task will not update!!
        
        */
        if (response.getBody().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}
