package util;

public class NumberUtil {

    public static int convertNumberFrom(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    public static void isNotPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    public static void isZeroNumber(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
