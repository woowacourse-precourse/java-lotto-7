package lotto.vo;

import lotto.constant.ErrorMessage;

public record LottoNumber(int value) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public LottoNumber(String input) {
        this(validateLottoNumber(input));
    }

    private static int validateLottoNumber(String input) {
        validateLetter(input);
        validateNumberRange(input);
        return Integer.parseInt(input);
    }

    private static void validateLetter(String input) {
        if (isLetter(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_CHARACTER_ERROR);
        }
    }

    private static void validateNumberRange(String input) {
        if (isOutOfLottoRange(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    private static boolean isLetter(String input) {
        return !(input.matches(SIGNED_NUMBER_REGEX));
    }

    private static boolean isOutOfLottoRange(String input) {
        return Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45;
    }
}
