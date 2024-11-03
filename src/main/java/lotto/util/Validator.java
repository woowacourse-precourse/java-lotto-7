package lotto.util;

public class Validator {

    public static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("로또 번호는 숫자 형식이어야 합니다.");
        }
    }
}
