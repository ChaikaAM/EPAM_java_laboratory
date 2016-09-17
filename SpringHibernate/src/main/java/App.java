import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Chaika Aleksei on 11.09.2016.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("datasource_config.xml");

        SessionFactory sessionFactory = classPathXmlApplicationContext.getBean(SessionFactory.class);

        for (int i = 0; i < 100; i++) {
            Student s = new Student("Vasya" + i, i+0L);
            s.setId(i+1L);
            Session session = sessionFactory.openSession();
            session.save(s);
            System.out.println(session.createQuery("from Student").getResultList());
//            session.load(Student.class, s);
            session.close();
            Thread.sleep(30);
            System.out.println(i);
        }
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        List resultList = query.getResultList();
        System.out.println(resultList);
    }
}
