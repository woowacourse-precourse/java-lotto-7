package lotto.util;

import java.util.List;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class Validator {
    public void validatePayment(int value) {
        isPositive(value);

        if (value % LottoConstants.PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PAYMENT);
        }
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        List<Integer> after = numbers.stream().distinct().toList();

        if (numbers.size() != after.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_FOUND);
        }

        if (numbers.size() != LottoConstants.SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_WINNING_NUMBER_COUNT);
        }

        numbers.forEach(this::validateLottoNumber);
    }

    public void validateLottoNumber(int value) {
        if (value < LottoConstants.NUMBER_START || value > LottoConstants.NUMBER_END) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private void isPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_NUMBER);
        }
    }
}
