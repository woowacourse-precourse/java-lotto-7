package lotto.model;

import java.util.List;
import lotto.util.Constants;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

/**
 * 로또 당첨 보너스 번호
 */
public class Bonus {

    private final int number;

    public Bonus(int number, List<Integer> lotto) {
        validate(number, lotto);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number, List<Integer> lotto) {
        validateDuplicates(number, lotto);
        validateRange(number);
    }

    @VisibleForTesting
    void validateDuplicates(int number, List<Integer> lotto) {
        if (lotto.stream().anyMatch(n -> n.equals(number))) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.DUPLICATE_NUMBERS.getMessage()));
        }
    }

    @VisibleForTesting
    void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_IN_LOTTO_RANGE.getMessage()));
        }
    }

    private boolean isOutOfRange(int number) {
        return number < Constants.MIN_LOTTO_NUMBER.getNumber() || number > Constants.MAX_LOTTO_NUMBER.getNumber();
    }
}
