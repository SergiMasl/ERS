package com.rev.transactins;

import com.rev.UserTransactionsObj;
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

public class Approve extends HttpServlet {
String uname;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Cookie[] cookies =  req.getCookies();
        if(cookies!=null){
            uname = cookies[0].getValue();
        }

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate2.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        List<UserTransactionsObj> tList = (List<UserTransactionsObj>) session.createQuery("from UserTransactionsObj u where u.userName='" + uname + "' and u.isAprove='Approve'", UserTransactionsObj.class).list();


        for (UserTransactionsObj u : tList) {
            out.println("<tr>");
            out.println("<td>" + u.getAmount() + "</td>");
            out.println("<td>" + u.getDate() + "</td>");
            out.println("<td>" + u.getNote() + "</td>");
            out.println("<td>" + u.getisAprove() + "</td>");
            out.println("</tr>");
        }
        session.clear();
        session.close();

        out.println("</br>");
        out.println("<a href='com.rev.transactins.AllTrans'>View AllTrans</a>");
        out.println("</br>");
        out.println("<a href='com.rev.transactins.Pending'>View Pending</a>");
        out.println("</br>");
        out.println("<a href='com.rev.transactins.Approve'>View Approved</a>");
        out.println("</br>");
        out.println("</br>");

        out.println("<form action='com.rev.Profile' method='post'><input type='submit' value='Back'>");


 }
}