package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");

        Long adId = Long.parseLong(req.getParameter("ad_id"));
        Ad ad = DaoFactory.getAdsDao().findUniqueAd(adId);

        if(user.getId() == ad.getUserId()) {
            DaoFactory.getAdsDao().delete(ad);
        } else {
            //TODO: create unauth page to redirect to. for now, i am redirecting to ads
        }

        resp.sendRedirect("/ads");


    }
}

