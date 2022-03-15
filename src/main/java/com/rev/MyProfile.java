package com.rev;

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

public class MyProfile extends HttpServlet {
    String userName;
    String role;
    String backBtn;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Cookie[] cookies =  req.getCookies();
        if(cookies!=null){
            userName = cookies[0].getValue();
            role = cookies[1].getValue();
        }

        if(role.equals("Administrator")){
            backBtn = "com.rev.admin.AdminHome";
        } else {
            backBtn = "com.rev.Profile";
        }


        List<User> profileList = session.createQuery("from User u where u.userName='" + userName + "'", User.class).list();

        for (User p : profileList) {
            out.println(" <link rel='stylesheet' href='profile.css'>");
            out.println("<div class='prof-contener'>");
            out.println("<div class='prof-wrap-main'>");
            out.println("<div class='prof-wrap'>");
            out.println("<div class='prof_left'>");

            out.println("<form action='"+backBtn+"' method='post' class='prof_back'><input type='submit'value='' class='myprofile_back'></form>");

            out.println("<div class='prof_img-wrap'>");
            out.println("<img class='prof-img' src='img/profImg.jfif' alt='Img profile'>");
            out.println("</div>");
            out.println("<div class='prof_name'>");
            out.println("<h3>"+p.getname()+"</h3>");
            out.println("<h5>Security Lead</h5>");
            out.println("</div>");

            out.println("<form action='com.rev.UpdateUserForm' method='post' class='btm-prof-cont'>" +
                    "<input type='hidden' name='userName' value='"+ userName+"'>" +
                    "<input type='hidden' name='name' value='"+ p.getname()+"'>" +
                    "<input type='hidden' name='address' value='"+ p.getadress()+"'>" +
                    "<input type='hidden' name='email' value='"+ p.getemail()+"'>" +
                    "<input type='hidden' name='phone' value='"+ p.getphone()+"'>" +
                    "<input type='hidden' name='role' value='"+ p.getrole()+"'>" +
                    "<input type='submit' value='Change profile' class='myprofile_submit'/>" +
                    "</form>");

            out.println("</div>");
            out.println("<div class='prof_right'>");
            out.println("<h3>My profile</h3>");
            out.println("<div class='user-info-contener'>");
            out.println("<div class='user-infoblock green'>");
            out.println("<div class='prof_svg svg_user'></div>");
            out.println("<p class='userName'>User name: </p>");
            out.println("   <p class='info'>"+ p.getuserName()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock blue'>");
            out.println("   <div class='prof_svg svg_adress'></div>");
            out.println("   <p class='userName'>Adress: </p>");
            out.println("   <p class='info'> "+ p.getadress()+ "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Phone: </p>");
            out.println("   <p class='info'>+1-" + p.getphone() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock red'>");
            out.println("   <div class='prof_svg email'></div>");
            out.println("   <p class='userName'>Email: </p>");
            out.println("   <p class='info'>"+p.getemail()+"</p>");
            out.println("</div></div></div></div></div></div>");
        }
    }
}
