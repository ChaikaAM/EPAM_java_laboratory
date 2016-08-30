package kingdom;

/**
 * Created by Chaika Aleksei on 26.08.2016.
 */
public class Knight {
    private String name;
    private int health;
    private final Weapon weapon;

    public Knight(String name, int healith, Weapon weapon) {
        this.weapon = weapon;
        this.health=healith;
        this.name = name;
    }

    public void atackAnotherKnight(Knight anotherKnight){
        if (!anotherKnight.isDead()) anotherKnight.health -= this.weapon.getPower();
    }

    public boolean isDead(){
        return health<=0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
