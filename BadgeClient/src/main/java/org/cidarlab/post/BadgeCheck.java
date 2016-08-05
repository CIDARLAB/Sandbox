/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.post;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;
import java.util.List;
import org.cidarlab.dom.BadgeEndPoints;
import org.json.JSONArray;

/**
 *
 * @author david
 */
public class BadgeCheck {
    
    public static List<String> getBadges(String username) throws UnirestException{
        HttpResponse<JsonNode> response = Unirest.post(BadgeEndPoints.RETR_BADGES)
                .field("username", username)
                .asJson();
        
        JSONArray badges = response.getBody().getArray();
        
        ArrayList<String> badgeList = new ArrayList<>();
        
        
        for(int i = 0; i < badges.length(); i++)
        {
                badgeList.add(badges.getJSONObject(i).getString("name"));
        }
        
        return badgeList;
    }
    
    public static List<String> searchByBadge(String badgename) throws UnirestException
    {
        HttpResponse<JsonNode> response = Unirest.post(BadgeEndPoints.SEARCH)
                .field("badgename", badgename)
                .asJson();

        JSONArray userArray = response.getBody().getArray();
        
        ArrayList<String> userList = new ArrayList<>();
        
        for(int i = 0; i < userArray.length(); i++)
        {
            userList.add(userArray.getJSONObject(i).getString("email"));
        }
        
        return userList;
    }
    
}
