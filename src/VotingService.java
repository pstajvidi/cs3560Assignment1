import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question;
    private Map<String, String> submissions;

    public VotingService(Question question) {
        this.question = question;
        this.submissions = new HashMap<>();
    }

    public void submitAnswer(Student student, String answer) {
        // Check if the answer is valid
        if (question.getOptions().contains(answer)) {
            submissions.put(student.getId(), answer);
        }
    }

    public void printResults() {
        Map<String, Integer> resultCounts = new HashMap<>();
        for (String option : question.getOptions()) {
            resultCounts.put(option, 0);
        }

        for (String answer : submissions.values()) {
            resultCounts.put(answer, resultCounts.get(answer) + 1);
        }

        for (Map.Entry<String, Integer> entry : resultCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

