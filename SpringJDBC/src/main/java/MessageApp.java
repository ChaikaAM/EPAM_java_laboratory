import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.test.context.ContextConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chaika Aleksei on 09.09.2016.
 */

public class MessageApp extends JdbcDaoSupport{

    JdbcTemplate jdbcTemplate = new ClassPathXmlApplicationContext("db_config.xml").getBean(JdbcTemplate.class);

    private static MessageApp instance = new MessageApp();

    public static void main(String[] args) {
        List<MessaageModel> query = instance.jdbcTemplate.query("SELECT * FROM messages", new RowMapper<MessaageModel>() {
            @Override
            public MessaageModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new MessaageModel(rs.getInt(1), rs.getDate(2), rs.getString(3));
            }
        });

        System.out.println(query);
    }
}
