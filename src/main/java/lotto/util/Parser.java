package lotto.util;

public class Parser {
    public static int parseStringToInt(String inputValue) {
        long number = Long.parseLong(inputValue);
        checkRange(number);
        return (int) number;
    }
    private static void checkRange(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            // TODO: 알맞은 Exception으로 변환
            throw new IllegalArgumentException();
        }
    }

}
