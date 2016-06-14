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
public class TaskForm extends LoginCredentials{

    public TaskForm(String email, String password, String badge, String user, String app) {
        super(email, password);
        this.badge = badge;
        this.user = user;
        this.app = app;
    }
    
    public String badge;
    public String user;
    public String app;
}
