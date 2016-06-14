/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.get;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_AWARDS;
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_BADGE;
import static org.cidarlab.dom.BadgeEndPoints.ADMIN_TASKS;
import org.cidarlab.dom.LoginCredentials;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Alex
 */
public class Lists extends LoginCredentials {

    public Lists(String email, String password) {
        super(email, password);
    }
    
    /**
     * Gets httpresponse string 
     * @param url the get url
     * @return HttpResponse String of the request
     * @throws com.mashape.unirest.http.exceptions.UnirestException
     * @throws java.io.IOException
     */
    public HttpResponse<String> basicGet(String url) throws UnirestException, IOException
    {
        if(login())
            return Unirest.get(url).asString();
        else 
            return null;
    }
    /**
     * gets list of "option" tag contents for specified "select" tag
     * @param selectName name of the "select" tag
     * @param url URL of page where "select" tag is located
     * @return List of "option" tag contents
     * @throws UnirestException
     * @throws IOException 
     */
    public List<String> getListOf(String selectName, String url) throws UnirestException, IOException
    {
        HttpResponse<String> response = basicGet(url);
        List<String> optionText = new ArrayList();
        if(response != null)
        {
            String body = response.getBody();
            Document doc = Jsoup.parse(body);
            Element select = doc.select("select[name=" + selectName + "]").first();
            if (select != null)
            {
                Elements options = select.select("option");
                for (Element option: options)
                {
                    optionText.add(option.text());
                }
            }
        }
        return optionText;
    }
    public List<String> getListOfBadges() throws UnirestException, IOException
    {
        return getListOf("badge", ADMIN_AWARDS);
    }
    public List<String> getListOfUsers() throws UnirestException, IOException
    {
        return getListOf("user", ADMIN_AWARDS);
    }
    public List<String> getListOfImages() throws UnirestException, IOException
    {
        return getListOf("image", ADMIN_BADGE);
    }
    public List<String> getListOfIssuers() throws UnirestException, IOException
    {
        return getListOf("issuer", ADMIN_BADGE);
    }  
    public List<String> getListOfTasks() throws UnirestException, IOException
    {
        return getListOf("typeselection", ADMIN_TASKS);
    }
    public List<String> getListOfApps() throws UnirestException, IOException
    {
        List<String> optionText = new ArrayList();
        if (login())
        {
            HttpResponse<String> response = Unirest.post(ADMIN_TASKS)
                        .field("flag", "False")
                        .field("typeselection", "percent")
                        .asString();
            if(response != null)
            {
                String body = response.getBody();
                Document doc = Jsoup.parse(body);
                Element select = doc.select("select[name=app]").first();
                if (select != null)
                {
                    Elements options = select.select("option");
                    for (Element option: options)
                    {
                        optionText.add(option.text());
                    }
                }
            }
        }
        return optionText;
    }
}
