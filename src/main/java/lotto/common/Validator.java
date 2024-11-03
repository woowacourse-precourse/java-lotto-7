package lotto.common;

import java.util.List;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

public class Validator {

    public static void checkValidPurchaseCount(int amount) {
        checkPositiveNumber(amount);

        if (amount % Lotto.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT);
    }

    public static void checkLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
        if (numbers.stream().distinct().toList().size() != Lotto.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }

        for (Integer number : numbers) {
            checkLottoNumber(number);
        }
    }

    public static void checkPositiveNumber(int number) {
        if (!(number > 0)) {
            throw new IllegalArgumentException(ErrorMessage.NO_POSITIVE_NUMBER);
        }
    }

    public static void checkLottoNumber(int bonusNumber) {
        if (!(Lotto.LOTTO_NUMBER_MIN_VALUE <= bonusNumber && bonusNumber <= Lotto.LOTTO_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public static void checkWinningNumber(List<Integer> lottoNumbers, int bonusNumber) {
        checkLottoNumbers(lottoNumbers);
        checkLottoNumber(bonusNumber);

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_BONUS_NUMBER);
        }
    }
}
