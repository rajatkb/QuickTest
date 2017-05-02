/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.quickTest;

import com.model.quickTest.dbManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author RAJAT
 */
public class initializeEverything implements ServletContextListener{
    
    @Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println("Server Started and initialising DBs");
                dbManager obj = new dbManager();
                obj.intialiseAllDB();
	}
    
}
