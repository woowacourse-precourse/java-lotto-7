package lotto.domain.lotto;

import lotto.domain.constants.message.InputError;
import lotto.domain.constants.message.RangeError;
import lotto.domain.constants.value.LottoRule;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {

    private final List<Number> answerNumbers;

    public LottoAnswer(List<Integer> answerNumbers) {
        validateDuplicate(answerNumbers);
        validateLength(answerNumbers);

        this.answerNumbers = answerNumbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }


    public void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoRule.COMBINATION_LENGTH.getValue()) {
            System.out.println(RangeError.LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }


    public void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            System.out.println(InputError.DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

}
