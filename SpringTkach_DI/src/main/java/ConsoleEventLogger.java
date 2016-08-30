/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
