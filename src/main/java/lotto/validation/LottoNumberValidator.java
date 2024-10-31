package lotto.validation;

public class LottoNumberValidator {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void validateDelimitedByComma(String input) {
        if (!input.matches("^\\d+(,\\d)*$")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "당첨 번호 입력 시, 쉼표(,)로 구분해야 합니다.");
        }
    }
}
