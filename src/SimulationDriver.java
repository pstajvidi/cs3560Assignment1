import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class SimulationDriver {
    public static void main(String[] args) throws Exception {
        // Step 1: Create a question and configure answers
        Question.QuestionType questionType = Question.QuestionType.SINGLE_CHOICE;
        List<String> options = Arrays.asList("A", "B", "C", "D");
        Question question = new Question(questionType, options);

        // Step 2: Configure the question for Voting Service
        VotingService votingService = new VotingService(question);

        // Step 3: Generate students and answers
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        int numberOfStudents = 100;

        for (int i = 1; i <= numberOfStudents; i++) {
            String studentId = "Student" + i;
            students.add(new Student(studentId));

            // Randomly select an answer
            String answer = options.get(random.nextInt(options.size()));
            votingService.submitAnswer(new Student(studentId), answer);
        }

        // Step 4: Print out the results
        votingService.printResults();

    }
}
