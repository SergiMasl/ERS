package com.rev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserForm extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String updateName = request.getParameter("name");
        String updateAddress = request.getParameter("address");
        String updatePhone = request.getParameter("phone");
        String updateEmail = request.getParameter("email");


        out.println("<h1>Type your new information: </h1>" +
                "    <form action='com.rev.UpdateUser' method='post'>" +
                "        <input type='text' name='name' Value='"+updateName+"'>" +
                "        <input type='text' name='address' Value='"+updateAddress+"'>" +
                "        <input type='text' name='phone' Value='"+updatePhone+"'>" +
                "        <input type='text' name='email' Value='"+updateEmail+"'>" +
                        "<input type='hidden' name='userName' value='"+ userName+"'>" +
                "        <input type='submit' value='Submit change'>" +
                "    </form>");

    }
}
