import java.util.*;

//question can become an interface so that it can have multiple different types, like single or multi
public interface Question {
    String getQuestionText();

    List<String> getAnswers();
    
    boolean isValidAnswer(List<String> answers);
}

class SingleChoiceQuestion implements Question {
    private String questionText;
    private List<String> candidateAnswers;

    //constructor for singleChoice 
    public SingleChoiceQuestion(String questionText, List<String> candidateAnswers) {
        this.questionText = questionText;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<String> getAnswers() {
        return candidateAnswers;
    }

    @Override
    public boolean isValidAnswer(List<String> answers) {
        return answers.size() == 1 && candidateAnswers.contains(answers.get(0));
        //retrun true when the their is only one and answer and the answer is at the 0 index
    }
}

class MultiChoiceQuestion implements Question {
    private String questionText;
    private List<String> candidateAnswers;

    //constructor for multi
    public MultiChoiceQuestion(String questionText, List<String> candidateAnswers) {
        this.questionText = questionText;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<String> getAnswers() {
        return candidateAnswers;
    }

    @Override
    public boolean isValidAnswer(List<String> answers) {
        for (String answer : answers) {
            if (!candidateAnswers.contains(answer)) {
                return false;
            }
        }
        //for all the answers given, if the candidate answers does not contain one of the answers return false
        return true;
    }
}


