import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class App {

    Client client;
    EventLogger eventLogger;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App appFromXML = classPathXmlApplicationContext.getBean("myapp", App.class);

        for (int i = 0; i < 10; i++) {
            Event anotherevent = classPathXmlApplicationContext.getBean("anotherevent", Event.class);
            anotherevent.setMessage("new event("+(i+1)+")");
            appFromXML.logEvent(anotherevent);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
