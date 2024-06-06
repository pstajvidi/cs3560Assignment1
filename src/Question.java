import java.util.List;

public class Question {
    //enum is like constents in csharp
    public enum QuestionType {
        SINGLE_CHOICE,
        MULTIPLE_CHOICE
    }

    private QuestionType type;
    private List<String> options;

    public Question(QuestionType type, List<String> options) {
        this.type = type;
        this.options = options;
    }

    public QuestionType getType() {
        return type;
    }
    public List<String> getOptions() {
        return options;
    }
   
}
