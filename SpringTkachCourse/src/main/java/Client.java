/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class Client {

    private int id;
    private String fullName;
    private String greeting;

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
