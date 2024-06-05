import java.util.List;

public class Question {
    //enum is like constents in csharp
    public enum QuestionType {
        SINGLE_CHOICE,
        MULTIPLE_CHOICE
    }

    private QuestionType type;
    private List<String> candidateAnswers;

    public Question(QuestionType type, List<String> candidateAnswers) {
        this.type = type;
        this.candidateAnswers = candidateAnswers;
    }

    public QuestionType getType() {
        return type;
    }

    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }
}
