/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.badgeclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author david
 */
public class PingAWS {

    public static void main(String[] args) throws IOException, MalformedURLException, UnirestException {
//        //LOGIN AS ADMIN PLS
        String targetURL = "http://52.39.236.237:8080/";
        boolean auth = login(targetURL, "beepboop@gmail.com", "hello");

        if (auth) {
            //BADGE CREATE
            String[] params = new String[6];
            params[0] = "Test Badge";
            params[1] = "Testing post request for peasantry badge creation";
            params[2] = "Bomberman.png";
            params[3] = "Being the best peasant you can be";
            params[4] = "Tag you're it";
            params[5] = "ME";

            System.out.println(auth);

            //FILE GET
            InputStream sonic = getFile(targetURL, "images/Sonic.png");
            Image image = ImageIO.read(sonic);

            JFrame frame = new JFrame("Sonic");
            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static boolean login(String targetURL, String email, String password) throws MalformedURLException, IOException, UnirestException {
        HttpResponse<String> response = Unirest.post(targetURL + "login")
                .field("email", email)
                .field("password", password)
                .asString();

        String rp = response.getBody();
        Document page = Jsoup.parse(rp);

        Elements hello = page.getElementsByTag("h2");
        for (Element msg : hello) {
            String parse = msg.text();
            if (parse.contains("Welcome back")) {
                return true;
            }
        }
        return false;

    }

    public static InputStream getFile(String baseURL, String extension) throws UnirestException {
        HttpResponse<InputStream> response = Unirest.get(baseURL + extension)
                .header("content-type", "*/*")
                .asBinary();

        return response.getBody();
    }

    public static boolean register(String URL, String name, String email, String password) throws UnirestException {
        if (name.isEmpty() || password.isEmpty()) {
            return false;
        }
        HttpResponse<String> response = Unirest.post(URL + "register")
                .field("name", name)
                .field("email", email)
                .field("password", password)
                .field("passwordcheck", password)
                .asString();

        Document doc = Jsoup.parse(response.getBody());
        Elements ele = doc.getElementsByTag("h2");
        for (Element wap : ele) {

            if (wap.toString().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean createBadge(String targetURL, String name, String description, String image, String criteria, String tags, String issuer) throws UnirestException {
        HttpResponse<String> response = Unirest.post(targetURL + "admin-badge")
                .field("name", name)
                .field("description", description)
                .field("image", image)
                .field("criteria", criteria)
                .field("tags", tags)
                .field("issuer", issuer)
                .asString();

        Document doc = Jsoup.parse(response.getBody());
        Elements ele = doc.getElementsByTag("h2");

        for (Element hehe : ele) {
            if (hehe.toString().contains("Your badge was successfully created!")) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean createIssuer(String targetURL, String name, String description, String issuerURL) throws UnirestException
    {
        HttpResponse<String> response = Unirest.post(targetURL + "issuer")
                .field("name", name)
                .field("description", description)
                .field("url", issuerURL)
                .asString();
        
        Document doc = Jsoup.parse(response.getBody());
        Elements all = doc.getElementsByTag("p");
        
        for(Element disOne : all)
        {
            if(disOne.toString().contains("Your issuer has been created!"))
            {
                return true;
            }
        }
        
        return false;
    }

}
