/**
 * Created by Chaika Aleksei on 29.08.2016.
 */
public class BraveKnight {

    private Minstrel minstrel;
    private String name;

    public BraveKnight(String name) {
        this.minstrel = new Minstrel();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doQuest(){
        System.out.println("------------------------------------");
        System.out.println("Knight " + getName() + " is fighting at the quest");

        for (int i = 0; i < 10; i++) {
            System.out.print("Boom-");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
