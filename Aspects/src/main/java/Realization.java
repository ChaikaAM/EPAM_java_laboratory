import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 29.08.2016.
 */
public class Realization {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("KnightsConfig.xml");
        BraveKnight braveKnight = (BraveKnight) classPathXmlApplicationContext.getBean("jayme");
        braveKnight.doQuest();

        BraveKnight braveKnight2 = new BraveKnight("not Bean knight");
        braveKnight2.doQuest();
    }
}
