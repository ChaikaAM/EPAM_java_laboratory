import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Chaika Aleksei on 11.09.2016.
 */
public class App {

    public static void main(String[] args) {
        DataSource bean = new ClassPathXmlApplicationContext("datasource_config.xml").getBean(DataSource.class);
        try {
            ResultSet resultSet = bean.getConnection().createStatement().executeQuery("SELECT * FROM groups");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
