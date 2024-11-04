package lotto.domain.number;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.DUPLICATE_BONUS_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {
    public static Number from(final int number) {
        return new Number(number);
    }

    public static Number createBonusNumber(final int number, final Numbers winningNumbers) {
        Number bonusNumber = NumberFactory.from(number);
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

        return new Number(randomNumber);
    }

    private static void validateBonusNumber(final Number bonusNumber, final Numbers winningNumbers) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
