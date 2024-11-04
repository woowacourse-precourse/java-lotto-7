package lotto.util;

public class StringToIntegerConverter {
    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해 주세요.");
        }
    }
}
