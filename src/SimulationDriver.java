import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver {
    public static void main(String[] args) {
         // Step 1: Create and test a single choice question
         testSingleChoiceQuestion();

         // Step 2: Create and test a multiple choice question
         testMultipleChoiceQuestion();
     }
 
     private static void testSingleChoiceQuestion() {
        System.out.println("Testing Single Choice Question...");

        // Create a single choice question and configure answers
        Question.QuestionType singleChoiceType = Question.QuestionType.SINGLE_CHOICE;
        List<String> singleChoiceOptions = Arrays.asList("A", "B", "C", "D");
        Question singleChoiceQuestion = new Question(singleChoiceType, singleChoiceOptions);

        // Configure the question for Voting Service
        VotingService singleChoiceVotingService = new VotingService(singleChoiceQuestion);

        // Generate students and a predefined answer for single choice
        generateSubmissions(singleChoiceVotingService, Arrays.asList("A"));

        // Allow user to submit their answer
        acceptUserSubmission(singleChoiceVotingService);

        // Print out the results for single choice
        singleChoiceVotingService.printResults();
    }

    private static void testMultipleChoiceQuestion() {
        System.out.println("Testing Multiple Choice Question...");

        // Create a single choice question and configure answers
        Question.QuestionType multiQuestionType = Question.QuestionType.MULTIPLE_CHOICE;
        List<String> multiChoiceOptions = Arrays.asList("A", "B", "C", "D");
        Question multiChoiceQuestion = new Question(multiQuestionType, multiChoiceOptions);

        // Configure the question for Voting Service
        VotingService multiChoiceVotingService = new VotingService(multiChoiceQuestion);

        // Generate students and a predefined answer for single choice
        generateSubmissions(multiChoiceVotingService, Arrays.asList("A"));

        // Allow user to submit their answer
        acceptUserSubmission(multiChoiceVotingService);

        // Print out the results for single choice
        multiChoiceVotingService.printResults();
    }

    private static void generateSubmissions(VotingService votingService, List<String> predefinedAnswers) {
        List<Student> students = new ArrayList<>();
        int numberOfStudents = 100;

        for (int i = 0; i < numberOfStudents; i++) {
            // Generate a random student ID
            String studentId = "Student" + (i + 1); // Generates sequential IDs: Student1, Student2, ...
            students.add(new Student(studentId));

            // Use predefined answers
            votingService.submitAnswers(new Student(studentId), predefinedAnswers);
        }
    }

    private static void acceptUserSubmission(VotingService votingService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to submit an answer? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            votingService.acceptUserInput();
        }
        else if (response.equalsIgnoreCase("no")){
            System.out.println("ok, printing current question stats");
        }
    }

}


