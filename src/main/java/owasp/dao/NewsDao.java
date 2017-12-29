package owasp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import owasp.domain.News;

@Component
public class NewsDao {

    private final String TABLE = "News";

    @Autowired
    private Database database;

    public void insert(String content) {
        try {
            database.getConnection().createStatement().executeUpdate("INSERT INTO " + TABLE + "(content) VALUES('"
                                                                    + content + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<News> getNews() {
        List<News> news = new ArrayList();
        try {
            ResultSet rs = database.getConnection().createStatement().executeQuery("SELECT * FROM " + TABLE);
            while (rs.next()) {
                news.add(new News(rs.getString("content")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

}
