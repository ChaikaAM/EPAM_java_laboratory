import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class Event {

    static int last_id = 0;

    private String message;
    private Date date;
    private DateFormat dateFormat;
    private int id;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.id=++last_id;
        this.dateFormat=dateFormat;
    }

    public static int getLast_id() {
        return last_id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return dateFormat.format(date) + " message id " + id +
                " : <" + message + ">";
    }
}
