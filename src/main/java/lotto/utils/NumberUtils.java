package lotto.utils;

public class NumberUtils {
    public static int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            validateNumber(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자가 포함되어 있습니다");
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 또는 음수는 입력할 수 없습니다");
        }
    }

    public static void validateFormat(String numbers, int size, String delimiter) {
        int count = numbers.length() - numbers.replace(delimiter, "").length(); // 구분자의 개수
        if (count + 1 != size) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 올바르지 않습니다.");
        }
    }
}
