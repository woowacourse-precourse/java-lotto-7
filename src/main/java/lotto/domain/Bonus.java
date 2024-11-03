package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.util.LottoValidator.*;

public class Bonus {

    private final Integer number;

    public Bonus(String number, Lotto winningLotto) {
        int parsedNumber = parseNumber(number);
        validateSingleNumberRange(parsedNumber);
        this.number = parsedNumber;
        validateNotContainsBonusBall(winningLotto);
    }

    public boolean containsBonusBall(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNotContainsBonusBall(Lotto winningLotto) {
        if (containsBonusBall(winningLotto))
            throw new IllegalArgumentException(BONUS_NUMBER_ALREADY_IN_WINNING_NUMBERS.getMessage());
    }
}
