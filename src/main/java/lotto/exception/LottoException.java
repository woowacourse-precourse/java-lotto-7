package lotto.exception;

public class LottoException {

    public static class InvalidBonusNumberException extends IllegalArgumentException {
        public InvalidBonusNumberException() {
            super(ErrorMessages.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public static class InvalidLottoRangeException extends IllegalArgumentException {
        public InvalidLottoRangeException() {
            super(ErrorMessages.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public static class InvalidLottoSizeException extends IllegalArgumentException {
        public InvalidLottoSizeException() {
            super(ErrorMessages.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public static class InvalidLottoPriceException extends IllegalArgumentException {
        public InvalidLottoPriceException() {
            super(ErrorMessages.INVALID_LOTTO_PRICE.getMessage());
        }
    }

    public static class InvalidLottoPriceDivisibleException extends IllegalArgumentException {
        public InvalidLottoPriceDivisibleException() {
            super(ErrorMessages.INVALID_LOTTO_PRICE_DIVISIBLE.getMessage());
        }
    }

    public static class InvalidLottoPriceTypeException extends IllegalArgumentException {
        public InvalidLottoPriceTypeException() {
            super(ErrorMessages.INVALID_LOTTO_PRICE_TYPE.getMessage());
        }
    }

    public static class InvalidLottoDuplicateException extends IllegalArgumentException {
        public InvalidLottoDuplicateException() {
            super(ErrorMessages.INVALID_LOTTO_DUPLICATE.getMessage());
        }
    }

}
