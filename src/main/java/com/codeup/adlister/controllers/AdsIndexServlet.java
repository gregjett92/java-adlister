package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//added user getid
@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        grabs current logged in user
        User user = (User) request.getSession().getAttribute("user");
//        provides front with access to all ad info
//        grabbing all the ads
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        checks if users logged in
        if(user != null) {
            request.setAttribute("user_id", user.getId());
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
