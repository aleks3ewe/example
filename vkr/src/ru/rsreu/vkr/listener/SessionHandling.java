package ru.rsreu.vkr.listener;

import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionHandling implements HttpSessionListener
{
 
    public SessionHandling()
    {
        System.out.println("You are in Session Handler");
    }
 
    public void sessionCreated(HttpSessionEvent sessionEvent)
    {
        HttpSession session = sessionEvent.getSession();
        String sessionID = session.getId();
        System.out.println("New session with Id " + sessionID + "is created at" + new Date());
 
    }
 
    public void sessionDestroyed(HttpSessionEvent sessionEvent)
    {
        HttpSession session = sessionEvent.getSession();
        String sessionID = session.getId();
        System.out.println("New session with Id " + sessionID + "is destroyed at" + new Date());
 
    }
}  