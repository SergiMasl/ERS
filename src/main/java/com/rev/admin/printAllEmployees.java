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

public class printAllEmployees extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();


        request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        List<User> employeeList = session.createQuery("from User", User.class).list();

        out.println("<link rel='stylesheet' href='css/usersView.css'>");
        out.println("<div class='users_contener spaceUser'>" +
                "               <h2>Users:</h2>" +
                "               <div class='input-wrap-user'>" +
                "                   <p class='input-money-text_name'>Employee Name: </p>" +
                "                    <div>|</div>" +
                "                    <p class='input-money-text_role'>Position:  </p>" +
                "                   <div>|</div>" +
                "                   <p class='input-money-text_email'>Email: </p>" +
                "                    <div>|</div>" +
                "                    <p class='input-money-text_phone'>Phone: </p>" +
                "                    <div>|</div>" +
                "                    <p class='input-money-text_balance'>Balance: </p>" +
                "                    <div>|</div>" +
                "                    <p class='input-money-text_adress'>Address: </p>" +
                "                       <p class='input-money-text_username'>UserName: </p>" +
                "        </div></div>");
        for(User e : employeeList){
            if(e.getname() == null){
                request.getRequestDispatcher("navbar.html").include(request, response);
            } else {
                out.println("<div class='users_contener'>" +
                        "        <div class='input-wrap-user'>" +
                        "            <p class='input-money-text_name'>"+e.getname()+" </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'>"+e.getrole()+"  </p>" +
                        "            <div>|</div>" +
                        "            <p class='input-money-text_name'><a class='user_link' href='email:"+e.getemail()+"'>"+e.getemail()+"</a> </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'><a class='user_link' href='tel:"+e.getphone()+"'>"+e.getphone()+"</a> </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_name'>"+e.getAmount()+" </p>" +
                        "             <div>|</div>" +
                        "             <p class='input-money-text_adress'>"+e.getadress()+" </p>" +
                        "             <p class='input-money-text_name'>"+e.getuserName()+" </p>" +
                        "        </div>" +
                        "    </div>");
            }
        }

        session.close();

    }
}
