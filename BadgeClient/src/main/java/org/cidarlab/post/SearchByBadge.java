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
import org.cidarlab.dom.BadgeEndPoints;
import org.cidarlab.get.Lists;
import org.json.JSONArray;

/**
 *
 * @author david
 */
public class SearchByBadge {
    
    public static JSONArray searchByBadge(String badgename) throws UnirestException
    {
        HttpResponse<JsonNode> response = Unirest.post(BadgeEndPoints.SEARCH)
                .field("badgename", badgename)
                .asJson();
        
        JsonNode users = response.getBody();
        JSONArray userArray = users.getArray();
        
        return userArray;
    }
    
}
