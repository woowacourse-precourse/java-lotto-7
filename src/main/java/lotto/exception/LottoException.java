package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class LottoException {

    public class DuplicateLottoNumberException extends IllegalArgumentException {
        public DuplicateLottoNumberException() {
            super(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public class EmptyInputException extends IllegalArgumentException {
        public EmptyInputException() {
            super(EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public class LottoNumberOutOfRangeException extends IllegalArgumentException {
        public LottoNumberOutOfRangeException() {
            super(LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public class MinLottoPriceException extends IllegalArgumentException {
        public MinLottoPriceException() {
            super(MIN_LOTTO_PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    public class PurchaseUnitException extends IllegalArgumentException {
        public PurchaseUnitException() {
            super(PURCHASE_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    public class InvalidLottoCountSizeException extends IllegalArgumentException {
        public InvalidLottoCountSizeException() {
            super(INVALID_LOTTO_COUNT_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    public class BonusNumberAlreadyIncludedWinningNumberException extends IllegalArgumentException {
        public BonusNumberAlreadyIncludedWinningNumberException() {
            super(BONUS_NUMBER_ALREADY_INCLUDED_WINNING_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public class NotAllowNegativeNumberException extends IllegalArgumentException {
        public NotAllowNegativeNumberException() {
            super(NOT_ALLOW_NEGATIVE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public class CharacterInputException extends IllegalArgumentException {
        public CharacterInputException() {
            super(CHARACTER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}