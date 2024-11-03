package lotto.util;

public class NumberUtil {
    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환될 수 없는 값입니다." + value);
        }
    }
}
