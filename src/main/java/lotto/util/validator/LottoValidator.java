package lotto.util.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException.InvalidBonusNumberException;
import lotto.exception.LottoException.InvalidLottoDuplicateException;
import lotto.exception.LottoException.InvalidLottoPriceDivisibleException;
import lotto.exception.LottoException.InvalidLottoPriceException;
import lotto.exception.LottoException.InvalidLottoRangeException;
import lotto.exception.LottoException.InvalidLottoSizeException;

public class LottoValidator {

    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int LOTTO_SIZE = 6;
    private final static int LOTTO_PRICE = 1000;

    public static void validateDuplicateWith(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }
    }

    public static void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoRangeException();
        }
    }

    public static void validateDivisible(int amount) {
        if ((amount / LOTTO_PRICE) * LOTTO_PRICE != amount) {
            throw new InvalidLottoPriceDivisibleException();
        }
    }

    public static void validatePrice(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new InvalidLottoPriceException();
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new InvalidLottoDuplicateException();
        }
    }

}
