package lotto.model;

import lotto.util.Constants;
import lotto.util.Errors;
import lotto.util.MessageParser;
import org.assertj.core.util.VisibleForTesting;

/*
로또 당첨 보너스 번호
*/
public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        validateRange(number);
    }

    @VisibleForTesting
    void validateRange(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER.getNumber() || number > Constants.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(
                    MessageParser.getErrorMessage(Errors.NOT_IN_LOTTO_RANGE.getMessage()));
        }
    }
}
