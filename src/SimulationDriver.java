import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SimulationDriver {
    public static void main(String[] args) throws Exception {
        // 1. Create a question type and configure the answers
        List<String> candidateAnswers = List.of("A", "B", "C", "D");
        Question question = new Question(Question.QuestionType.SINGLE_CHOICE, candidateAnswers);

        // 2. Configure the question for iVote Service
        VotingService votingService = new VotingService();
        votingService.configureQuestion(question);

        // 3. Randomly generate a number of students and their answers
        int numberOfStudents = 100;
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfStudents; i++) {
            students.add(new Student("Student" + (i + 1)));
        }

        // 4. Submit all the students’ answers to iVote Service
        for (Student student : students) {
            String randomAnswer = candidateAnswers.get(random.nextInt(candidateAnswers.size()));
            votingService.submitAnswer(student.getId(), randomAnswer);
        }

        // 5. Call the Voting Service output function to display the result
        votingService.printResults();
    }
}
