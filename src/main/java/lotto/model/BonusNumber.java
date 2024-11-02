package lotto.model;

import lotto.controller.error.ErrorType;

public class BonusNumber {

    private final int number;

    public BonusNumber(final int number, final Lotto lotto) {
        validateDuplicate(number, lotto);
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber of(final String number, final Lotto lotto) {
        return new BonusNumber(parseBonusNumber(number), lotto);
    }

    private static int parseBonusNumber(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_FORMAT.getMessage(), e);
        }
    }

    private static void validateDuplicate(final int number, final Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ErrorType.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(final int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
