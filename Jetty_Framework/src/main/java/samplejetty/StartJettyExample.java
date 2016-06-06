/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejetty;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author prash
 */
public class StartJettyExample {
    public static void main(String[] args) {
        Server server = new Server(8080);
        
                
        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        
        
        
        
        WebAppContext contextWeb = new WebAppContext();
        contextWeb.setDescriptor(context + "/WEB-INF/web.xml");
        contextWeb.setResourceBase("../Jetty_Framework/src/main/webapp");
        contextWeb.setContextPath("/");
        contextWeb.setParentLoaderPriority(true);
        
        HandlerList handlers = new HandlerList();
        handlers.addHandler(contextWeb);
        server.setHandler(handlers);
        
        try
        {
            server.start();
            server.join();
        }
        catch(Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }
}
