package com.rev;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LogIn extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        List<User> userList = session.createQuery("from User u where u.userName='"+ username + "'", User.class).list();

        for(User u : userList) {
            Cookie cookie = new Cookie("username", u.getuserName());
            Cookie cookie2 = new Cookie("role", u.getrole());
            res.addCookie(cookie);
            res.addCookie(cookie2);

            if(u.getrole().equals("Administrator")){
                if(username.equals(u.getuserName()) && password.equals(u.getPassword())){
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("com.rev.admin.AdminHome");
                    requestDispatcher.forward(req, res);
                } else{
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
                    requestDispatcher.forward(req, res);
                }
            } else {
                if (username.equals(u.getuserName()) && password.equals(u.getPassword())) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("com.rev.Profile");
                    requestDispatcher.forward(req, res);
                }
                else{
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
                    requestDispatcher.forward(req, res);
                }
            }

        }


        session.close();

    }

}
