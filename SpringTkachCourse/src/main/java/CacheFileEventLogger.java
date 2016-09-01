import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Chaika Aleksei on 31.08.2016.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    List<Event> cache = new ArrayList<>();
    private final Event loggedFromCache = new Event(new Date(), DateFormat.getDateTimeInstance());
    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public CacheFileEventLogger(String filePath) {
        super(filePath);
    }

    @Override
    public void logEvent(Event event) {
        loggedFromCache.setMessage("-------------------------------------\nLogged from cash:");
        cache.add(event);
        if (cache.size()==cacheSize){;
            super.logEvent(loggedFromCache);
            for (int i = 0; i < cacheSize; i++) {
                super.logEvent(cache.get(i));
            }
            cache.clear();
        }
    }

    private void destory(){
        loggedFromCache.setMessage("-------------------------------------\nClosing program:");
        super.logEvent(loggedFromCache);
        for (int i = 0; i < cacheSize; i++) {
            super.logEvent(cache.get(i));
        }
        cache.clear();
    }
}