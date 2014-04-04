/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jatismobile.workshop.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lukman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("WorkshopSpringConfig.xml");
    }
     
    
}
