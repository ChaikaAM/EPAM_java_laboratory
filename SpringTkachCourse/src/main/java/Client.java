/**
 * Created by Chaika Aleksei on 30.08.2016.
 */
public class Client {

    private int id;
    private String fullName;

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
}