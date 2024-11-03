package lotto.utils;

import java.util.List;

public class WinningNumbersValidator {

    private static void validateAllNumeric(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력된 값 중 숫자가 아닌 값이 있습니다.");
            }
        }
    }

    private static void validateInRange(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이여야 합니다.");
            }
        }
    }

}
