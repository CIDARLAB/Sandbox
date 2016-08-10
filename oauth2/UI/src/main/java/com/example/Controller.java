/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alex
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/doStuff", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String helloWorld() {
        return "<p>WOW! Something worked! Magic!</p>";
    }

}