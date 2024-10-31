package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer extends NumberCombination {

    private final List<Number> answerNumbers;

    public LottoAnswer(List<Integer> answerNumbers) {
        validateDuplicate(answerNumbers);
        validateLength(answerNumbers);

        this.answerNumbers = answerNumbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
