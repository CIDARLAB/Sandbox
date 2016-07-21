/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.badgeclient;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.cidarlab.get.Files;
import org.cidarlab.get.Lists;
import org.cidarlab.post.BadgeCheck;
import org.cidarlab.post.BadgeForm;
import org.cidarlab.post.IssuerForm;
import org.cidarlab.post.PercentTaskForm;
import org.cidarlab.post.PerformanceTaskForm;
import org.cidarlab.post.RegisterForm;
import org.cidarlab.post.RepeatTaskForm;
import org.cidarlab.post.TaskUpdate;
import org.cidarlab.post.TimeTrialTaskForm;
import org.cidarlab.post.UniqueTaskForm;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author david
 */
public class PingAWS {

    public static void main(String[] args) throws IOException, MalformedURLException, UnirestException {

        //GET FILES
        InputStream sonic = Files.get("images/N-A.jpg");
        Image img = ImageIO.read(sonic);

        JFrame frame = new JFrame("Sonic");
        JLabel label = new JLabel(new ImageIcon(img));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        //GET LISTS
        String email = "beepboop@gmail.com";
        String password = "hello";
        Lists lists = new Lists(email, password);

        List<String> check = BadgeCheck.getBadges(email);

        String badgename = check.get(0);

        System.out.println("Searching for users with : " + badgename);

        List<String> search = BadgeCheck.searchByBadge(badgename);

        System.out.println("Owners: ");
        for (int j = 0; j < search.size(); j++) {
            System.out.println(search.get(j));

            //Destination file
            File file = new File("/home/david/Desktop/" + search.get(j).replace("@", "-at-").replace(".", "-dot-") + badgename.replace(" ", "-") + ".png");
            InputStream bakedbadgeStream = Files.getBakedBadge(search.get(j), badgename);

            OutputStream out = new FileOutputStream(file);
            int len;
            byte[] bytes = new byte[1024];

            while ((len = bakedbadgeStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            bakedbadgeStream.close();
            out.close();
        }
        System.out.println("-------------------");

        //Gets all general lists from the web form made by Josh. Can and will make direct requests to server in future.
        List<String> list1 = lists.getListOfBadges();
        List<String> list2 = lists.getListOfUsers();
        List<String> list3 = lists.getListOfImages();
        List<String> list4 = lists.getListOfIssuers();
        List<String> list5 = lists.getListOfTasks();
        List<String> list6 = lists.getListOfApps();

        Random gen = new Random();

        int random = gen.nextInt(1000);
        //POST BADGE
        String name = "name #" + Integer.toString(random);
        String description = "description";
        String image = list3.get(gen.nextInt(list3.size()));
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
        String badge = list1.get(gen.nextInt(list1.size()));
        String user = list2.get(0);
        String app = list6.get(0);
        String circuit = "circuit";
        String initialScore = "0";
        String percentImprovement = "100";
        PercentTaskForm form3 = new PercentTaskForm(email, password, badge, user, app, circuit, initialScore, percentImprovement);
        boolean success3 = form3.post();

        //Post Performance Task Form
        String targetyield = "5";
        String cost = "20";
        PerformanceTaskForm form4 = new PerformanceTaskForm(email, password, badge, user, app, circuit, targetyield, cost);
        boolean success4 = form4.post();

        //Post Register Form
        boolean success5 = RegisterForm.register("Al", "all@hoopla.com", "asdf");

        //Post RepeatTaskForm
        String repetitions = "5";
        RepeatTaskForm form6 = new RepeatTaskForm(email, password, badge, user, app, circuit, repetitions);
        boolean success6 = form6.post();

        //Post Time Trial Task Form
        String days = "0";
        String hours = "1";
        String minutes = "50";
        String tasknum = "5";
        TimeTrialTaskForm form7 = new TimeTrialTaskForm(email, password, badge, user, app, days, hours, minutes, circuit, tasknum);
        boolean success7 = form7.post();

        //Post Unique Task Form
        String unique = "unique";
        UniqueTaskForm form8 = new UniqueTaskForm(email, password, badge, user, app, unique);
        boolean success8 = form8.post();

        double num1 = 2;
        double num2 = 4;

        TaskUpdate update = new TaskUpdate(user, app, circuit, num1, num2);

        for (int i = 0; i < 5; i++) {
            update.score++;
            update.cost++;
            update.submit();
        }

        System.out.println("Fin");
    }
}
