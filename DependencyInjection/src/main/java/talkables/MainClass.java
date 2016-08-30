package talkables;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chaika Aleksei on 23.08.2016.
 */
public class MainClass {

    static ApplicationContext applicationContext;

    static Talkable talkable;

    public static void main(String[] args) {

        initContext();
        for (int i = 0; i < 100; i++) {
            if (i%10==0){
                System.out.println("Initing new talkables.Talkable");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initContext();
            }
            System.out.println(i+": "+talkable.getClass().getSimpleName() + " says \"" + talkable.saysomething()+"\"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void initContext(){
        applicationContext =
                new ClassPathXmlApplicationContext("TalkableBeans.xml");
        System.out.println(applicationContext.getBeanDefinitionNames());
        talkable = (Talkable) applicationContext.getBean("talkable");
    }

}
