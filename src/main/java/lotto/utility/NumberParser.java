package lotto.utility;

public class NumberParser {

    public static int parseToInteger(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자를 입력하셨습니다.");
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 수는 입력하실 수 없습니다.");
        }
    }
}
