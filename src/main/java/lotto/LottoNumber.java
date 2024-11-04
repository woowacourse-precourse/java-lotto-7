package lotto;

public record LottoNumber(int value) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public LottoNumber(String value) {
        this(validateLottoNumber(value));
    }

    private static int validateLottoNumber(String value) {
        validateLetter(value);
        return Integer.parseInt(value);
    }

    private static void validateLetter(String value) {
        if (isLetter(value)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 문자가 아닌 숫자여야 합니다.");
        }
    }

    private static boolean isLetter(String value) {
        return !value.matches(SIGNED_NUMBER_REGEX);
    }
}
