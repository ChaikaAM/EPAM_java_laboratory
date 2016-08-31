import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class App {

    Client client;
    EventLogger eventLogger;
    public static void main(String[] args) {
        ConfigurableApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App appFromXML = classPathXmlApplicationContext.getBean("myapp", App.class);

        for (int i = 0; i < 39; i++) {
            Event anotherevent = classPathXmlApplicationContext.getBean("anotherevent", Event.class);
            anotherevent.setMessage("new event("+(i+1)+")"+System.lineSeparator());
            appFromXML.logEvent(anotherevent);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        classPathXmlApplicationContext.close();
    }

    private void logEvent(Event ebent){
        this.eventLogger.logEvent(ebent);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }
}
