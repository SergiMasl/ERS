package com.rev.admin;

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

public class ViewDisapprove extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

   //     request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        out.println("<h1> Disapproved Reimbursement Requests </h1>");
        List<UserTransactionsObj> employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Disapprove'", UserTransactionsObj.class).list();
        for(UserTransactionsObj e : employeeList){
            out.println();


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
            out.println("   <p class='info'> "+ e.getId()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock blue'>");
            //out.println("   <div class='prof_svg svg_adress'></div>");
            out.println("   <p class='userName'>Account Username: </p>");
            out.println("   <p class='info'> "+ e.getUserName() + "</p>");
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
            out.println("   <p class='info'> " + e.getDate() + "</p>");
            out.println("</div>");
            //out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            // out.println("   <div class='prof_svg svg_mail'></div>");
            out.println("   <p class='userName'>Status: </p>");
            out.println("   <p class='info'> " + e.getisAprove() + "</p>");
            out.println("</div>");
            // out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Employee Note: </p>");
            out.println("   <p class='info'> " + e.getNote() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock red'>");
            //out.println("   <div class='prof_svg email'></div>");
            out.println("   <p class='userName'>Admin Note: </p>");
            out.println("   <p class='info'> "+  e.getAdminNote() +"</p>");
            out.println("</div>");
            out.println("</div></div></div></div></div></div>");

        /*    out.println();
            out.println("Request ID: " + e.getId() + "<br>");
            out.println("Account Username: " + e.getUserName() + "<br>");
            out.println( "Amount: " + e.getAmount() + "<br>");
            out.println( "Date: " + e.getDate() + "<br>");
            out.println( "Status: " + e.getisAprove() + "<br>");
            out.println( "Employee Note: " + e.getNote() + "<br>");
            out.println( "Admin Note: " + e.getAdminNote() + "<br>");
            out.println("<br>"); */
        }

        session.close();

    }
}
