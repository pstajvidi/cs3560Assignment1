import java.util.*;

public class Student {
    private static int idCounter = 0;
    private String id;

    public Student() {
        this.id = generateUniqueId();
    }

    private synchronized String generateUniqueId() {
        return "Student-" + (idCounter++);
    }

    public String getId() {
        return id;
    }

    public void submitAnswer(VotingService votingService, List<String> answers) {
        votingService.submitAnswer(this, answers);
    }
}
