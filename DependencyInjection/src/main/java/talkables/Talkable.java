package talkables;

/**
 * Created by Chaika Aleksei on 23.08.2016.
 */
public interface Talkable {

    public default String saysomething(){
        return "bla-bla-bla";
    }
}
