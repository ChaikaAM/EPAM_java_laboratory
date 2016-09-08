import junit.framework.Assert;
import lab.dao.CountryDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Chaika Aleksei on 07.09.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MyJDBCTest {

    @Autowired
    public CountryDao countryDao;

//    public DataSource dataSource = countryDao.getDataSource();

    @Test
    public void testBeans(){
        Assert.assertNotNull(countryDao);
    }

    @Before
    @Test
    public void loadDB() throws SQLException {
        JdbcTemplate jdbcTemplate = countryDao.getJdbcTemplate();
        jdbcTemplate.getDataSource().getConnection().createStatement().execute("CREATE TABLE country");
    }
}
