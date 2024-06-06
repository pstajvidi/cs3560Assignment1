import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VotingService {
    private Question question;
    private HashMap<String, Set<String>> submissions; // Stores student ID and their submissions

    public VotingService() {
        this.submissions = new HashMap<>();
    }

    public void configureQuestion(Question question) {
        this.question = question;
    }

    public void submitAnswer(String studentId, String answer) {
        if (question == null) {
            throw new IllegalStateException("Question not configured.");
        }

        if (!question.getCandidateAnswers().contains(answer)) {
            throw new IllegalArgumentException("Invalid answer.");
        }

        if (question.getType() == Question.QuestionType.SINGLE_CHOICE) {
            Set<String> singleAnswerSet = new HashSet<>();
            singleAnswerSet.add(answer);
            submissions.put(studentId, singleAnswerSet);
        } else {
            submissions.computeIfAbsent(studentId, k -> new HashSet<>()).add(answer);
        }
    }

    public void printResults() {
        HashMap<String, Integer> results = new HashMap<>();
        for (String answer : question.getCandidateAnswers()) {
            results.put(answer, 0);
        }

        for (Set<String> answers : submissions.values()) {
            for (String answer : answers) {
                results.put(answer, results.get(answer) + 1);
            }
        }

        for (HashMap.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
