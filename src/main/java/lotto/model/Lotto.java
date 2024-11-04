package lotto.model;

import java.util.List;
import lotto.util.Constants;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

/**
 * 로또 당첨번호
 */
public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    @VisibleForTesting
    void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.LOTTO_NUMBER_COUNT_ERROR.getMessage()));
        }
    }

    @VisibleForTesting
    void validateDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.DUPLICATE_NUMBERS.getMessage()));
        }
    }

    @VisibleForTesting
    void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfRange)) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_IN_LOTTO_RANGE.getMessage()));
        }
    }

    private boolean isOutOfRange(int number) {
        return number < Constants.MIN_LOTTO_NUMBER.getNumber() || number > Constants.MAX_LOTTO_NUMBER.getNumber();
    }
}
