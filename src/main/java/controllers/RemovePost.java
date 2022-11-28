package controllers;

import DAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/remove")
public class RemovePost extends HttpServlet {   //MIGHT NOT WORK, SINCE I CHANGEDLOGIN PROTECTION
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDAO.removePost(request.getParameter("post_id"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("home");
        dispatcher.forward(request,response);
    }
}
