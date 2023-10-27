package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(value = "/add")
public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName") ;
        String lastName = request.getParameter("lastName");

        if(firstName!= null &&  lastName != null){
            User user = new User(firstName, lastName);
            Warehouse.getInstance().addUser(user);
            request.setAttribute("user", user);
        }
        request.getServletContext()
                .getRequestDispatcher("/jsp/add.jsp")
                .forward(request,response);
    }
}
