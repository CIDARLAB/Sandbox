/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.dom;

/**
 *
 * @author Alex
 */
public class BadgeEndPoints {
    
    public static final String  SITE = "http://52.39.236.237:8080";    
    public static final String SEP= "/";
    
    //FILE GETS
    public static String STATIC     = SITE + SEP + "static";
    public static String BADGES = SITE + SEP + "badges";
    public static String ISSUERS = SITE + SEP + "issuers";
    public static String USERS = SITE + SEP + "users";
    public static String IMAGES = SITE + SEP + "images";
    public static String CRITERIA = SITE + SEP + "criteria";
    public static String AWARDEDBADGES = SITE + SEP + "awardedbadges";
    
    //MAIN ROUTING FUNCS
    public static String MYPROFILE = SITE + SEP + "myprofile";
    public static String LOGOUT = SITE + SEP + "logout";
    public static String REGISTER = SITE + SEP + "register";
    public static String LOGIN = SITE + SEP + "login";
    public static String ADMIN_BADGE = SITE + SEP + "admin-badge";
    public static String ADMIN_ISSUER = SITE + SEP + "admin-issuer";
    public static String ADMIN_AWARDS = SITE + SEP + "admin-awards";
    public static String ADMIN_IMAGES = SITE + SEP + "admin-images";
    public static String ADMIN_TASKS = SITE + SEP + "admin-tasks";

}