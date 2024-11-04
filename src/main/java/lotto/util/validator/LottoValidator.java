package lotto.util.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException.InvalidBonusNumberException;
import lotto.exception.LottoException.InvalidLottoDuplicateException;
import lotto.exception.LottoException.InvalidLottoPriceDivisibleException;
import lotto.exception.LottoException.InvalidLottoPriceException;
import lotto.exception.LottoException.InvalidLottoRangeException;
import lotto.exception.LottoException.InvalidLottoSizeException;
import lotto.util.constants.LottoConstants;

public class LottoValidator {

    public static void validateDuplicateWith(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }
    }

    public static void validateRange(int number) {
        if (number < LottoConstants.LOTTO_MIN_NUMBER.getValue()
                || number > LottoConstants.LOTTO_MAX_NUMBER.getValue()) {
            throw new InvalidLottoRangeException();
        }
    }

    public static void validateDivisible(int amount) {
        if ((amount / LottoConstants.LOTTO_PRICE.getValue()) * LottoConstants.LOTTO_PRICE.getValue() != amount) {
            throw new InvalidLottoPriceDivisibleException();
        }
    }

    public static void validatePrice(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE.getValue()) {
            throw new InvalidLottoPriceException();
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE.getValue()) {
            throw new InvalidLottoSizeException();
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConstants.LOTTO_SIZE.getValue()) {
            throw new InvalidLottoDuplicateException();
        }
    }

}
