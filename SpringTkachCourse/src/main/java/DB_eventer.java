import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Chaika Aleksei on 08.09.2016.
 */


public class DB_eventer {

    private static ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("db_config.xml");
    private static JdbcTemplate jdbcTemplate = classPathXmlApplicationContext.getBean(JdbcTemplate.class);

    private static void initTableEvents(){
        try {
            jdbcTemplate.execute("CREATE TABLE EVENTS(id INT, date DATE, message VARCHAR(255))");
        } catch (Exception e){
            jdbcTemplate.execute("DROP TABLE EVENTS");
            jdbcTemplate.execute("CREATE TABLE EVENTS(id INT, date DATE, message VARCHAR(255))");
        }
        for (int i = 0; i < 20; i++) {
            Event anotherevent = new Event(new Date(), new SimpleDateFormat());
            anotherevent.setMessage(i+"");
            jdbcTemplate.update("INSERT INTO EVENTS (id, message) VALUES (?, ?)", anotherevent.getId(), anotherevent.getMessage());
        }
        List<Event> query = jdbcTemplate.query("select * from events", new RowMapper<Event>() {
            @Override
            public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
                Event event = new Event(new Date(), new SimpleDateFormat());
                event.setMessage(rs.getString(3));
                return event;
            }
        });
        System.out.println(query);
    }
    public static void main(String[] args) {
        System.out.println(jdbcTemplate);
        initTableEvents();
    }
}
