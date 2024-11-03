package lotto.domain.model.bonus;

import lotto.domain.constant.LottoConstants;
import lotto.exception.bonus.BonusErrorMessages;

import java.util.List;

public class BonusNumber {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int number;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        this.number = parseAndValidate(input, winningNumbers);
    }

    private int parseAndValidate(String input, List<Integer> winningNumbers) {
        checkIsPositiveInteger(input);

        int number = Integer.parseInt(input);
        checkRange(number);
        checkNotDuplicate(number, winningNumbers);

        return number;
    }

    private void checkIsPositiveInteger(String input) {
        if (!input.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(BonusErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkRange(int num) {
        if (num < LottoConstants.MIN_LOTTO_NUMBER || num > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BonusErrorMessages.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private void checkNotDuplicate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BonusErrorMessages.DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}