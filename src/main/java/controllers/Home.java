package controllers;

import DAO.UserDAO;
import DAO.UserPostDAO;
import model.User;
import model.User_Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String operacia = request.getParameter("operacia");
        if (operacia == null) {                                 // toto moze eventualne robit problemy?
            //zobraz prihlasovaciu stranku
        }
        else if (operacia.equals("login")) {
            if (UserDAO.checkIfUserExists(request.getParameter("nickname"), request.getParameter("pwd"))) {
                // USPESNE PRIHLASENIE
                User user = UserDAO.getUserByNick(request.getParameter("nickname"));
                System.out.println("corect");
                session.setAttribute("user", user);



            } else {
                //wrong credentials
                System.out.println("wrong cred");
                session.invalidate();
            }
        } else if (operacia.equals("logout")){
            request.getSession().invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }

        if (String.valueOf(request.getParameter("act")).equals("add")) {
            System.out.println("true");
            request.getSession().setAttribute("act","add");
        }

        if (request.getParameter("ban") != null){
            UserDAO.banUser(request.getParameter("ban"));
            request.removeAttribute("ban");
        }


        List<User_Post> user_postList = new ArrayList<>();
        user_postList.addAll(UserPostDAO.getAllPosts());


        request.getSession().setAttribute("userPostList", user_postList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home-page.jsp");
        dispatcher.forward(request,response);





    }
}
