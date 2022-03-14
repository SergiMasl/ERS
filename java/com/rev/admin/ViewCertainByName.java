package com.rev.admin;

import com.rev.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCertainByName extends HttpServlet {
    String uname;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String name = fName +" " + lName;

        //    request.getRequestDispatcher("navbar.html").include(request, response);

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        List<User> employeeList = (List<User>)session.createQuery("from User u where u.name='" + name + "'", User.class).list();

        out.println("<h4> Specified by Name </h4>");

        for(User e : employeeList) {
            out.println();
            uname = e.getuserName();
            out.println("<p>"+name+"</p>");
            out.println("<br>");
            out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='approve' value='approve'><input type='hidden' name='uname' value='"+uname+"'> <input type='submit' value='View Approved of this user'></form>");
            out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='disapprove' value='disapprove'><input type='hidden' name='uname' value='"+uname+"'> <input type='submit' value='View Disapproved of this user'></form>");
            out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='pending' value='pending'><input type='hidden' name='uname' value='"+uname+"'> <input type='submit' value='View Pending of this user'></form>");
            out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='all' value='all'><input type='hidden' name='uname' value='"+uname+"'> <input type='submit' value='View All of this user'></form>");



            out.println(" <link rel='stylesheet' href='adminHome.css'>");
            out.println("<div class='prof-contener'>");
            out.println("<div class='prof-wrap-main'>");

            out.println("<div class='prof-wrap'>");

            out.println("<div class='prof_right'>");




            // out.println("<h3>My profile</h3>");
            out.println("<div class='user-info-contener'>");
            out.println("<div class='user-infoblock green'>");
            //out.println("<div class='prof_svg svg_user'></div>");
            out.println("<p class='userName'>Request ID: </p>");
            out.println("   <p class='info'> "+ e.getname()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock blue'>");
            //out.println("   <div class='prof_svg svg_adress'></div>");
            out.println("   <p class='userName'>Username: </p>");
            out.println("   <p class='info'> "+ e.getadress() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            // out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Amount: </p>");
            out.println("   <p class='info'> $" + e.getAmount() + "</p>");
            out.println("</div>");
            //out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Date: </p>");
            out.println("   <p class='info'> " + e.getphone() + "</p>");
            out.println("</div>");
            //out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            // out.println("   <div class='prof_svg svg_mail'></div>");
            out.println("   <p class='userName'>Status: </p>");
            out.println("   <p class='info'> " + e.getrole() + "</p>");
            out.println("</div>");
            // out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Username: </p>");
            out.println("   <p class='info'> " + e.getuserName() + "</p>");
            out.println("</div>");
            out.println("</div></div></div></div></div></div>");
/*
            out.println("Name: " + e.getname() + "<br>");
            out.println("Address: " + e.getadress() + "<br>");
            out.println("Phone Number: " + e.getphone() + "<br>");
            out.println("Position: " + e.getrole() + "<br>");
            out.println("Username:" + e.getuserName() + "<br>");*/

            uname = e.getuserName();
            session.close();
        }

    }
}