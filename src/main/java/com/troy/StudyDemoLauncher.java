package com.troy;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class StudyDemoLauncher {

    public static void main(String[] args) throws Exception {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getFile();
        path = path.replace("target/classes/", "");
        path = path.replace("classes/", "");
        Server server = new Server(8052);
        String web = path + "src/main/webapp/";
        WebAppContext context = new WebAppContext();
        context.setDescriptor(web + "WEB-INF/web.xml");
        context.setResourceBase(web);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        context.setMaxFormContentSize(600000);
        //新增jetty的session保持会话时间
        SessionHandler hand = new SessionHandler();
        SessionManager manager = new HashSessionManager();
        manager.setMaxInactiveInterval(86400);
        hand.setSessionManager(manager);
        context.setSessionHandler(hand);
        server.setHandler(context);
        server.start();
        server.join();


    }
}
