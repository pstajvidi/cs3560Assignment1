import java.util.*;

public class VotingService {

    private Question question;
   
    private Map<String, List<String>> submissions = new HashMap<>();

    public void configureQuestion(Question question) {
        this.question = question;
    }

    public void submitAnswer(Student student, List<String> answers) {
        if (question.isValidAnswer(answers)) {
            submissions.put(student.getId(), answers);
        }
    }
    public void printStatistics() {
        Map<String, Integer> answerCounts = new HashMap<>();
        for (String answer : question.getAnswers()) {
            answerCounts.put(answer, 0);
        }

        for (List<String> answers : submissions.values()) {
            for (String answer : answers) {
                answerCounts.put(answer, answerCounts.get(answer) + 1);
            }
        }

        System.out.println("Number of students who submitted answers: " + submissions.size());
        System.out.println("Statistics for question: " + question.getQuestionText());
        for (String answer : question.getAnswers()) {
            System.out.println(answer + ": " + answerCounts.get(answer));
        }
    }
    
}




