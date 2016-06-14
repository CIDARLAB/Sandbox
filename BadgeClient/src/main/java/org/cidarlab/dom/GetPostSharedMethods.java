/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.dom;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Alex
 */
public abstract class GetPostSharedMethods {
    public boolean HTMLSearch(String phrase, String element, HttpResponse<String> response)
    {
        String rp = response.getBody();
        Document page = Jsoup.parse(rp);

        Elements hello = page.getElementsByTag(element);
        for (Element msg : hello) {
            String parse = msg.text();
            if (parse.contains(phrase)) {
                return true;
            }
        }
        return false;
    }
}
