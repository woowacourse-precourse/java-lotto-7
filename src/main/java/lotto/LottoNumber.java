package lotto;

public record LottoNumber(int value) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public LottoNumber(String value) {
        this(validateLottoNumber(value));
    }

    private static int validateLottoNumber(String value) {
        if (!value.matches(SIGNED_NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 문자가 아닌 숫자여야 합니다.");
        }
        return Integer.parseInt(value);
    }
}
