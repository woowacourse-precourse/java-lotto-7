package lotto.utils;

import java.math.BigDecimal;

public class Utils {

    //숫자 인지 확인
    public static boolean isDigitOnly (String input) {
        return input.matches("\\d+");
    }

    public static boolean isInRange (BigDecimal min, BigDecimal max, BigDecimal value) {
        return (value.compareTo(min) >= 0 && value.compareTo(max) <= 0);
    }

    //문자열을 int로 바꾸는 메서드
    public static int stringToInteger (String input) {
        return Integer.parseInt(input);
    }

    //입력을 숫자로 바꾸는 메서드
    public static BigDecimal stringToNumber (String input) {
        return new BigDecimal(input);
    }
}