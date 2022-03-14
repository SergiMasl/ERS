package com.rev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserForm extends HttpServlet {
    String backBtn;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String updateName = request.getParameter("name");
        String updateAddress = request.getParameter("address");
        String updatePhone = request.getParameter("phone");
        String updateEmail = request.getParameter("email");
        String role = request.getParameter("role");

        if(role.equals("Administrator")){
            backBtn = "navbar.html";
        } else {
            backBtn = "navbarUser.html";
        }

        request.getRequestDispatcher(backBtn).include(request, response);
        out.println("<link rel='stylesheet' href='css/userUpdate.css'>");
        out.println("<div class='body_contener'>" +
                "        <form class='user_update_form' action='com.rev.UpdateUser' method='post'>" +
                "            <div class='user_update_wrap'>" +
                "                <p class='user_update_text'>Name: </p>" +
                "               <lable class='user_update_lable' >" +
                "                   <div class='prof_svg'>" +
                "                       <img src='img/person_black_24dp.svg' alt='user' class='user_update_image'></div>" +
                "                   <input class='user_update_input' type='text' name='name' Value='"+updateName+"'>" +
                "               </lable>" +
                "            </div>" +
                "            <div class='user_update_wrap'>" +
                "                <p class='user_update_text'>Address: </p>" +
                "<lable class='user_update_lable' > <div class='prof_svg'>  <img src='img/home_black_24dp.svg' alt='Address' class='user_update_image'></div> " +
                "                <input class='user_update_input' type='text' name='address' Value='"+updateAddress+"'>" +
                "            </lable></div>" +
                "            <div class='user_update_wrap'>" +
                "                <p class='user_update_text'>Phone: +1</p>" +
                "<lable class='user_update_lable' > <div class='prof_svg'>  <img src='img/call_black_24dp.svg' alt='Phone' class='user_update_image'></div>" +
                "                <input class='user_update_input' type='text' name='phone' Value='"+updatePhone+"'>" +
                "            </lable></div>" +
                "            <div class='user_update_wrap'>" +
                "                <p class='user_update_text'>Email:</p>" +
                "<lable class='user_update_lable' > <div class='prof_svg'>  <img src='img/mail_black_24dp.svg' alt='Email' class='user_update_image'></div>" +
                "                <input class='user_update_input' type='text' name='email' Value='"+updateEmail+"'>" +
                "             </lable></div>" +
                "            <input class='user_update_input' type='hidden' name='userName' value='"+ userName+"'>" +
                "            <input class='user_update_submit' type='submit' value='Submit change'>" +
                "        </form>" +
                "    </div>");

    }
}
