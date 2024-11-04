package lotto.util;

public class IntegerConvertor {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }
}
