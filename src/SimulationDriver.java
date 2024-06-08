import java.util.*;

public class SimulationDriver {
    public static void main(String[] args) {
        List<String> candidateAnswers1 = Arrays.asList("A", "B", "C", "D");
        Question singleChoiceQuestion = new SingleChoiceQuestion("What is your favorite color?", candidateAnswers1);

        // Configure multi choice question
        List<String> candidateAnswers2 = Arrays.asList("Option 1", "Option 2", "Option 3");
        Question multiChoiceQuestion = new MultiChoiceQuestion("Select all applicable options:", candidateAnswers2);

        // Create voting services
        VotingService votingService1 = new VotingService();
        votingService1.configureQuestion(singleChoiceQuestion);

        VotingService votingService2 = new VotingService();
        votingService2.configureQuestion(multiChoiceQuestion);

        // Simulate students and submissions
        Random random = new Random();
        int numStudents = 20; // Adjust number of students as needed
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            students[i] = new Student();
        }

        // Simulate single choice answers
        System.out.println("Simulating single choice question answers...");
        for (Student student : students) {
            String answer = candidateAnswers1.get(random.nextInt(candidateAnswers1.size()));
            student.submitAnswer(votingService1, Arrays.asList(answer));
        }

        // Print results for single choice question
        votingService1.printStatistics();

        // Simulate multi choice answers
        System.out.println("\nSimulating multi choice question answers...");
        for (Student student : students) {
            int numAnswers = random.nextInt(candidateAnswers2.size()) + 1;
            List<String> answers = candidateAnswers2.subList(0, numAnswers);
            student.submitAnswer(votingService2, answers);
        }

        // Print results for multi choice question
        votingService2.printStatistics();
    }
}



