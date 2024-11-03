package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class LottoException {

    public static class DuplicateLottoNumberException extends IllegalArgumentException {
        public DuplicateLottoNumberException() {
            super(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public static class EmptyInputException extends IllegalArgumentException {
        public EmptyInputException() {
            super(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static class LottoNumberOutOfRangeException extends IllegalArgumentException {
        public LottoNumberOutOfRangeException() {
            super(LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public static class LowThenMinLottoPriceException extends IllegalArgumentException {
        public LowThenMinLottoPriceException() {
            super(MIN_LOTTO_PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    public static class PurchaseUnitException extends IllegalArgumentException {
        public PurchaseUnitException() {
            super(PURCHASE_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    public static class InvalidLottoCountSizeException extends IllegalArgumentException {
        public InvalidLottoCountSizeException() {
            super(INVALID_LOTTO_COUNT_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    public static class BonusNumberAlreadyIncludedWinningNumberException extends IllegalArgumentException {
        public BonusNumberAlreadyIncludedWinningNumberException() {
            super(BONUS_NUMBER_ALREADY_INCLUDED_WINNING_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public static class NotAllowNegativeNumberException extends IllegalArgumentException {
        public NotAllowNegativeNumberException() {
            super(NOT_ALLOW_NEGATIVE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public static class NotAllowCharacterInputException extends IllegalArgumentException {
        public NotAllowCharacterInputException() {
            super(CHARACTER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}