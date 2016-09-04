import java.util.List;

/**
 * Created by Chaika Aleksei on 04.09.2016.
 */
public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers=loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger: loggers) {
            eventLogger.logEvent(event);
        }
    }
}
