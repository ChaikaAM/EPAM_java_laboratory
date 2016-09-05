import AnnotationsPlusXMLExample.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class App {

    Client client;
    Map<EventType,EventLogger> eventLoggersMap;
    EventLogger defaultEventLogger;

    public static void main(String[] args) {
        ConfigurableApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        App appFromXML = classPathXmlApplicationContext.getBean("myapp", App.class);
        App bean = classPathXmlApplicationContext.getBean(App.class);
        for (int i = 0; i < 39; i++) {
            Event anotherevent = classPathXmlApplicationContext.getBean("anotherevent", Event.class);
            anotherevent.setMessage("new event("+(i+1)+")"+System.lineSeparator());
            appFromXML.logEvent(anotherevent, EventType.ERROR);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(classPathXmlApplicationContext.getBean("test"));

        classPathXmlApplicationContext.close();
    }

    private void logEvent(Event ebent, EventType eventType){
        if (eventType==null){
            defaultEventLogger.logEvent(ebent);
        } else this.eventLoggersMap.get(eventType).logEvent(ebent);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEventLoggersMap(Map<EventType,EventLogger> eventLoggersMap) {
        this.eventLoggersMap = eventLoggersMap;
    }

    public void setDefaultEventLogger(EventLogger defaultEventLogger) {
        this.defaultEventLogger = defaultEventLogger;
    }

    public String x2(){
        return "x2";
    }
}
