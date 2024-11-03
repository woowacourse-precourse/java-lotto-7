package lotto.model;

import java.util.Collections;
import java.util.List;

public class Answer {

    private final List<Integer> answerNumbers;
    private final BonusNumber bonusNumber;

    public Answer(List<Integer> answerNumbers, BonusNumber bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return List.copyOf(answerNumbers);
    }
}
