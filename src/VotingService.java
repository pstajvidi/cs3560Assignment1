import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VotingService {

    private Question question;
    //map of string to a list of string, 
    private Map<String, List<String>> submissions;

    //constructor
    public VotingService(Question question) {
        this.question = question;
        this.submissions = new HashMap<>();
    }

    
    public void submitAnswers(Student student, List<String> answers) {
        for (String answer : answers) {
            if (!question.getOptions().contains(answer)) {
                return; // Invalid answer, ignore submission
            }
        }
        // Check if the question is SINGLE_CHOICE and ensure only one answer is submitted
        if (question.getType() == Question.QuestionType.SINGLE_CHOICE && answers.size() != 1) {
            return; // Invalid submission for single choice, ignore submission
        }

        // Overwrite the previous submission if any
        submissions.put(student.getId(), answers);
       
        }
    

    
    public void acceptUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter your answers separated by commas: ");
        String answerInput = scanner.nextLine();
        List<String> answers = Arrays.asList(answerInput.split("\\s*,\\s*"));

        submitAnswers(new Student(studentId), answers);

    }

    public void printResults() {
        Map<String, Integer> resultCounts = new HashMap<>();
        
        // Initialize the count for each option to 0
        for (String option : question.getOptions()) {
            resultCounts.put(option, 0);
        }

        // Count the submissions for each option
        for (List<String> answers : submissions.values()) {
            for (String answer : answers) {
                resultCounts.put(answer, resultCounts.get(answer) + 1);
            }
        }

        // Print out the results
        for (Map.Entry<String, Integer> entry : resultCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}




