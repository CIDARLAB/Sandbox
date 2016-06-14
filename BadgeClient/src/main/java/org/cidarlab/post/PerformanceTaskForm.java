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
public class PerformanceTaskForm extends TaskForm {
    public String circuit;
    public String targetyield;
    public String cost;

    public PerformanceTaskForm(String email, String password, String badge, String user, String app, String circuit, String targetyield, String cost) {
        super(email, password, badge, user, app);
        this.circuit = circuit;
        this.targetyield = targetyield;
        this.cost = cost;
    }
    
    public boolean post() throws IOException, MalformedURLException, UnirestException
    {
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_TASKS)
                .field("badge", badge)
                .field("user", user)
                .field("app", app)
                .field("circuit", circuit)
                .field("targetyield", targetyield)
                .field("cost", cost)
                .field("flag", "True")
                .field("typeselection", "performance")
                .asString();
            return HTMLSearch("Your badge was successfully created!", "h2", response);
        }
        return false;
    }
}
