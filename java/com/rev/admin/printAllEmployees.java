package com.rev.admin;

import com.rev.User;
import com.rev.UserTransactionsObj;
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

public class printAllEmployees extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();


//        request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        //List<User> employeeList = session.createQuery("from User", User.class).list();
        List<User> userList = session.createQuery("from User u where u.role='user'", User.class).list();
        out.println("<h1> Employee List</h1>");
        for(User e : userList){
            out.println(" <link rel='stylesheet' href='adminHome.css'>");

            out.println("<div class='prof-contener'>");
            out.println("<div class='prof-wrap-main'>");
            out.println("<div class='prof-wrap'>");

            out.println("<div class='prof_right'>");

            //my profile
          //  out.println("<h3>My profile</h3>");
            out.println("<div class='user-info-contener'>");
            out.println("<div class='user-infoblock green'>");
         //   out.println("<div class='prof_svg svg_user'></div>");
            out.println("<p class='userName'>Name: </p>");
            out.println("   <p class='info'> "+ e.getname()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock blue'>");
           // out.println("   <div class='prof_svg svg_adress'></div>");
            out.println("   <p class='userName'>Status: </p>");
            out.println("   <p class='info'> "+ e.getrole()+ "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock red'>");
            //out.println("   <div class='prof_svg email'></div>");
            out.println("   <p class='userName'>Email: </p>");
            out.println("   <p class='info'> " + e.getemail() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Phone Number: </p>");
            out.println("   <p class='info'>+1-"+e.getphone()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Address: </p>");
            out.println("   <p class='info'> " + e.getadress() + "</p>");
            out.println("</div>");
            out.println("</div></div></div></div></div></div>");
         //   out.println("<br>");
/*
            out.println();
            out.println("Employee Name: " + e.getname() + "<br>");
            out.println( "Position: " + e.getrole() + "<br>");
            out.println("Employee email: " + e.getemail() + "<br>");
            out.println( "Phone Number: " + e.getphone() + "<br>");
            out.println( "Address: " + e.getadress() + "<br>");
            out.println("<br>");*/
        }

        session.close();

    }
}
