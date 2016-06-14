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
public class TimeTrialTaskForm extends TaskForm{
    public String days;
    public String hours;
    public String minutes;
    public String circuit;
    public String tasknum;

    public TimeTrialTaskForm(String email, String password, String badge, String user, String app, String days, String hours, String minutes, String circuit, String tasknum) {
        super(email, password, badge, user, app);
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.circuit = circuit;
        this.tasknum = tasknum;
    }
    
    public boolean post() throws IOException, MalformedURLException, UnirestException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_TASKS)
                .field("badge", badge)
                .field("user", user)
                .field("app", app)
                .field("days", days)
                .field("hours", hours)
                .field("minutes", minutes)
                .field("circuit", circuit)
                .field("tasknum", tasknum)
                .field("flag", "True")
                .field("typeselection", "timetrial")
                .asString();
            return HTMLSearch("Your badge was successfully created!", "h2", response);
        }
        return false;
    }
}
