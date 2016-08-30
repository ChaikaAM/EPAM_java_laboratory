package kingdom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 26.08.2016.
 */
public class Battle {

    static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("Knights.xml");

    static Knight knight1 = (Knight) applicationContext.getBean("knight1");
    static Knight knight2 = (Knight) applicationContext.getBean("knight2");

    public static void main(String[] args) throws InterruptedException {
        while (!knight1.isDead() && !knight2.isDead()){
            System.out.println(knight1.getName() + "("+knight1.getHealth()+") atacking " + knight2.getName() + "("+knight2.getHealth()+")");
            knight1.atackAnotherKnight(knight2);
            Thread.sleep(500);
            System.out.println(knight2.getName() + "("+knight2.getHealth()+") atacking " + knight1.getName() + "("+knight1.getHealth()+")");
            knight2.atackAnotherKnight(knight1);
            Thread.sleep(500);
        }
        if (knight1.isDead()) System.out.println(knight1.getName() + " is defeated by "+knight2.getName());
        if (knight2.isDead()) System.out.println(knight2.getName() + " is defeated by "+knight1.getName());
    }

}
