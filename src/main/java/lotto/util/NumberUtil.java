package lotto.util;

public class NumberUtil {
    public static int parsePositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 양수만 입력할 수 있습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 유효한 정수를 입력해주세요.");
        }
    }
}
