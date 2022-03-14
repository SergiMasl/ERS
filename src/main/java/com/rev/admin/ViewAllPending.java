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

public class ViewAllPending extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

   //     request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        List<UserTransactionsObj> employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Pending'", UserTransactionsObj.class).list();

        request.getRequestDispatcher("navbar.html").include(request, response);
        out.println("<link rel='stylesheet' href='css/reimbursemts.css'>");

        out.println("<div class='contener2'>" +
                "        <h2>All Reimbursements</h2>" +
                "        <div class='input-wrap-money'>" +
                "               <p class='input-money-text_user'>User Name: </p>" +
                "                <div>|</div>" +
                "               <p class='input-money-text_amount'>Amount of Reimburses: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_date'>Date:  </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_note'>Note: </p>" +
                "                <div>|</div>" +
                "                <p class='input-money-text_isAprove'>Status: </p>" +
                "        </div>" +
                "    </div>");
        for(UserTransactionsObj u: employeeList){
            out.println("<div class='contener3'><div class='input-wrap-money'>" +
                    "           <p class='input-money-text_user'>"+u.getUserName()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_amount'>"+u.getAmount()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_date'>"+u.getDate()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_note'>"+u.getNote()+"</p>" +
                    "            <div>|</div>" +
                    "            <p class='input-money-text_isAprove'>"+u.getisAprove()+"</p>" +
                    "        </div></div>");
        }
        out.println("<div></div>");

        session.close();

    }
}
