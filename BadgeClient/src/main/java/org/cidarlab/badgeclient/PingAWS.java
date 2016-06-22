/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.badgeclient;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.cidarlab.get.Files;
import org.cidarlab.get.Lists;
import org.cidarlab.post.BadgeForm;
import org.cidarlab.post.IssuerForm;
import org.cidarlab.post.PercentTaskForm;
import org.cidarlab.post.PerformanceTaskForm;
import org.cidarlab.post.RegisterForm;
import org.cidarlab.post.RepeatTaskForm;
import org.cidarlab.post.TimeTrialTaskForm;
import org.cidarlab.post.UniqueTaskForm;

/**
 *
 * @author david
 */
public class PingAWS {

    public static void main(String[] args) throws IOException, MalformedURLException, UnirestException {

        //GET FILES
        InputStream sonic = Files.get("images/Sonic.png");
        Image img = ImageIO.read(sonic);

        JFrame frame = new JFrame("Sonic");
        JLabel label = new JLabel(new ImageIcon(img));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
        //GET LISTS
        String email = "alex@hoopla.com";
        String password = "asdf";
        Lists lists = new Lists(email, password);
        
        List<String> list1 = lists.getListOfBadges();
        List<String> list2 = lists.getListOfUsers();
        List<String> list3 = lists.getListOfImages();
        List<String> list4 = lists.getListOfIssuers();
        List<String> list5 = lists.getListOfTasks();
        List<String> list6 = lists.getListOfApps();
        
        //POST BADGE
        String name = "name name";
        String description = "description";
        String image = list3.get(0);
        String criteria = "criteria";
        String tags = "tags";
        String issuer = list4.get(0);
        
        BadgeForm form1 = new BadgeForm(email, password, name, description, image, criteria, tags, issuer);
        boolean success1 = form1.post();
        
        //POST Issuer
        String issuerURL = "http://test.com";
        IssuerForm form2 = new IssuerForm(email, password, name, description, issuerURL);
        boolean success2 = form2.post();
        
        //Post Percent Task Form
        String badge = list1.get(0);
        String user = list2.get(0);
        String app = list6.get(0);
        String circuit = "circuit";
        String initialScore = "0";
        String percentImprovement = "100";
        PercentTaskForm form3 = new PercentTaskForm(email, password, badge, user, app, circuit, initialScore, percentImprovement);
        boolean success3 = form3.post();
        
        //Post Performance Task Form
        String targetyield = "targetyield";
        String cost = "cost";
        PerformanceTaskForm form4 = new PerformanceTaskForm(email, password, badge, user, app, circuit, targetyield, cost);
        boolean success4 = form4.post();
        
        //Post Register Form
        boolean success5 = RegisterForm.register("Al", "al@hoopla.com", "asdf");
        
        //Post RepeatTaskForm
        String repetitions = "repetitions";
        RepeatTaskForm form6 = new RepeatTaskForm(email, password, badge, user, app, circuit, repetitions);
        boolean success6 = form6.post();
        
        //Post Time Trial Task Form
        String days = "days";
        String hours = "hours";
        String minutes = "minutes";
        String tasknum = "task num";
        TimeTrialTaskForm form7 = new TimeTrialTaskForm(email, password, badge, user, app, days, hours, minutes, circuit, tasknum);
        boolean success7 = form7.post();
        
        //Post Unique Task Form
        String unique = "unique";
        UniqueTaskForm form8 = new UniqueTaskForm(email, password, badge, user, app, unique);  
        boolean success8 = form8.post();
        
        System.out.println("Fin");
    }
}