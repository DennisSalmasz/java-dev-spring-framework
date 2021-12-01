import service.MentorAccount;
import service.PartTimeMentor;

public class CyberApp {

    public static void main(String[] args) {

        //FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(partTime);

        mentor.manageAccount();
    }
}
