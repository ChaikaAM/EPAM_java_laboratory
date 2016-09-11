import java.sql.Date;

/**
 * Created by Chaika Aleksei on 09.09.2016.
 */
public class MessaageModel {
    private int id;
    private Date date;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessaageModel(int id, Date date, String message) {
        this.id = id;
        this.date = date;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message " + id + " " + date + " : <" + message + ">";
    }
}
