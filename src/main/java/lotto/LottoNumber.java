package lotto;

public record LottoNumber(int value) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public LottoNumber(String input) {
        this(validateAndParse(input));
    }

    private static int validateAndParse(String input) {
        validateLetter(input);
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }

    private static void validateLetter(String input) {
        if (isLetter(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 문자가 아닌 숫자여야 합니다.");
        }
    }

    private static boolean isLetter(String value) {
        return !value.matches(SIGNED_NUMBER_REGEX);
    }
}
