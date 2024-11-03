package lotto.model;

import java.util.List;
import java.util.regex.Pattern;

public class Answer {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 45;

    private final List<Integer> answerNumbers;

    public Answer(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public List<Integer> getAnswerNumbers() {
        return List.copyOf(answerNumbers);
    }
}
