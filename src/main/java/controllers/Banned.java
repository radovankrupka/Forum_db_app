package controllers;

import DAO.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/banned")
public class Banned extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("unban") != null){
            UserDAO.unbanUser(request.getParameter("unban"));
            request.removeAttribute("unban");
        }


        List<User> userList = new ArrayList<>();
        userList = UserDAO.getAllBannedUsers();

        request.getSession().setAttribute("bannedUsers", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/banned-users.jsp");
        dispatcher.forward(request,response);
    }
}
