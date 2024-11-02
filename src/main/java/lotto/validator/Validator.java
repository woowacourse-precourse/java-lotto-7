package lotto.validator;

public class Validator {
    public static void validateInput(String input) {
        final int DIVIDER = 1000;

        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }

        int value = Integer.parseInt(input);
        if (value % DIVIDER != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나눌 수 없는 값이 입력되었습니다.");
        }
    }
}
