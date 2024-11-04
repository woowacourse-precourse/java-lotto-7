package lotto.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    private static final String NUMBER_RANGE = "[ERROR] 입력한 값이 유효하지 않습니다. 1에서 45 사이의 숫자만 입력할 수 있습니다.";
    private static final String ONLY_INTEGER = "[ERROR] 정수만 입력할 수 있습니다.";

    public static int convertInputPurchaseStringToInt(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(ONLY_INTEGER);
        }

        try {
            return Integer.parseInt(input); // 문자열을 정수로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_INTEGER); // 변환 실패 시 예외 발생
        }
    }

    public static List<Integer> convertStringToList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(s -> Integer.parseInt(s.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_INTEGER);
        }
    }

    public static int convertBonusNumberStringToInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NUMBER_RANGE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_INTEGER);
        }
    }
}
