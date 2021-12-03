import com.cyber.configs.CyberAppConfig;
import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyberApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CyberAppConfig.class);

        Course course = container.getBean("java",Course.class);

        System.out.println(course.toString());

        course.getTeachingHours();
    }
}
