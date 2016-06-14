/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.post;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static org.cidarlab.dom.BadgeEndPoints.REGISTER;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Alex
 */
public class RegisterForm {

    public static boolean register(String name, String email, String password) throws UnirestException {
        if (name.isEmpty() || password.isEmpty()) {
            return false;
        }
        HttpResponse<String> response = Unirest.post(REGISTER)
                .field("name", name)
                .field("email", email)
                .field("password", password)
                .field("passwordcheck", password)
                .asString();
        
        //check if successful register
        Document doc = Jsoup.parse(response.getBody());
        Elements ele = doc.getElementsByTag("h2");
        for (Element wap : ele) {
            if (wap.toString().contains(name)) {
                return true;
            }
        }
        return false;
    }
}
