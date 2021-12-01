import interfaces.Mentor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberApp {

    public static void main(String[] args) {

        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        //Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
        //Mentor mentor = (Mentor) container.getBean("partTimeMentor");
        Mentor mentor = container.getBean("fullTimeMentor",Mentor.class);
        mentor.createAccount();
    }
}
