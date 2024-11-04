package lotto.common;

public class NumberParser {

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 형식이 올바르지 않습니다.");
        }
    }
}
