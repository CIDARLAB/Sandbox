/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.badgeclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import org.cidarlab.dom.BadgeEndPoints;
import org.cidarlab.get.Lists;
import org.cidarlab.post.BadgeCheck;
import org.cidarlab.post.TaskUpdate;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author david
 */
public class testSearch {

    public static void main(String[] args) throws UnirestException, IOException {

        Lists lists = new Lists("beepboop@gmail.com", "hello");

        String badgename = lists.getListOfBadges().get(0);
        System.out.println(badgename);

        System.out.println(BadgeCheck.searchByBadge(badgename));



        
    }

}
