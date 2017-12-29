package main;

import objects.User;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler();

        server.setHandler(servletContextHandler);
        servletContextHandler.addServlet(new ServletHolder(new SignInServlet()),"/signin");
        servletContextHandler.addServlet(new ServletHolder(new SignUpServlet()),"/signup");

        server.join();
        System.out.println("Server started");
        server.start();
    }
}
