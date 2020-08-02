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
import static java.lang.Long.parseLong;

@WebServlet(name = "EditAdsServlet", urlPatterns = "/ads/edit")
public class EditAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("We made it to edit serv");
        User user = (User) req.getSession().getAttribute("user");
        String adId = req.getParameter("ad_id");
        Ad ad = DaoFactory.getAdsDao().findUniqueAd(parseLong(adId));

        if(user.getId() != ad.getUserId()) {
//            redirect user and let them know they dont have permission
        } else {
            req.getSession().setAttribute("ad", adId);
            req.getSession().setAttribute("currentTitle", ad.getTitle());
            req.getSession().setAttribute("currentDesc", ad.getDescription());

            req.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");

        String adId = req.getParameter("adId");
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        System.out.println(adId);
        Ad ad = DaoFactory.getAdsDao().findUniqueAd(parseLong(adId));

        if(user.getId() == ad.getUserId()) {
            DaoFactory.getAdsDao().edit(ad, title, desc);
        } else {
            // TODO: create unauth page to redirect to. For now, I am redirecting to ads
        }


        resp.sendRedirect("/ads");

    }
}
