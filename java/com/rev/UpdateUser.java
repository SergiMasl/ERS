package com.rev;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UpdateUser extends HttpServlet {
    String uname;
    String role;
    String backBtn;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String updateName = request.getParameter("name");
        String updateAddress = request.getParameter("address");
        String updatePhone = request.getParameter("phone");
        String updateEmail = request.getParameter("email");
        String userName = request.getParameter("userName");

        Configuration config = new Configuration();

        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> userList = (List<User>)session.createQuery("from User", User.class).list();

        String qryString = "update User u set u.name='" + updateName + "', u.adress='" + updateAddress + "', u.phone='" + updatePhone + "', u.email='" + updateEmail + "' where u.userName='"+userName+"'";
        Query query = session.createQuery(qryString);
        int count = query.executeUpdate();
        transaction.commit();
        session.clear();

        Cookie[] cookies =  request.getCookies();
        if(cookies!=null){
            uname = cookies[0].getValue();
            role = cookies[1].getValue();
        }

        if(role.equals("Administrator")){
            backBtn = "com.rev.admin.AdminHome";
        } else {
            backBtn = "com.rev.Profile";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(backBtn);
        requestDispatcher.forward(request, response);

        session.close();
        out.close();


    }
}
