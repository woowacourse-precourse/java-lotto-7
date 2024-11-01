package lotto.domain.Random;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.BIGGER_THAN_LOTTO_MAX_NUMBER;
import static lotto.resources.ErrorMessages.SMALLER_THAN_LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private final int number;

    private Number(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number createNumber(final int number) {
        return new Number(number);
    }

    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

        return createNumber(randomNumber);
    }

    private void validateNumber(final int number) {
        validateNumberBiggerThanMinNumber(number);
        validateNumberSmallerThanMaxNumber(number);
    }

    private void validateNumberBiggerThanMinNumber(final int number) {
        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(SMALLER_THAN_LOTTO_MIN_NUMBER.getMessage());
        }
    }

    private void validateNumberSmallerThanMaxNumber(final int number) {
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BIGGER_THAN_LOTTO_MAX_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
