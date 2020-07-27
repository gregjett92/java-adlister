package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class DaoFactory implements Users {
    private static Ads adsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}
