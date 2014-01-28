package com.tz.quiz.controller;

import com.tz.quiz.service.SmashService;


public class SmashController {

    /**
     * <pre>
     * main(String[] args)
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args){
    	SmashService service = new SmashService();
    	service.smashZombie();
        
    }
}
