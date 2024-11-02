package lotto.model;

import java.util.List;
import lotto.util.Constants;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

/*
로또 당첨번호
*/
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicates(numbers);
    }

    @VisibleForTesting
    void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(
                    MessageParser.getLottoErrorMessage(Errors.LOTTO_NUMBER_COUNT_ERROR.getMessage()));
        }
    }

    @VisibleForTesting
    void validateDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(
                    MessageParser.getLottoErrorMessage(Errors.DUPLICATE_NUMBERS.getMessage()));
        }
    }
}
