package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;
import models.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection conn;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String selectAds = "SELECT id, user_id, title, description FROM ads";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectAds);
            while(rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long lastInsertedId = 0;
        String insertQuery = String.format(
                "INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription());
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastInsertedId;
    }

//    public static void main(String[] args) {
//        Ads adsDao = new MySQLAdsDao(new Config());
////        System.out.println(adsDao.all());
//        Ad testAd = new Ad(1,"Test ad title", "Test ad description");
//        System.out.println(adsDao.insert(testAd)); // 6
//    }
}