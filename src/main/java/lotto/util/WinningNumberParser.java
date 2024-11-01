package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumberParser {

    private static final String INVALID_WINNING_NUMBER = "[ERROR] 당첨 번호는 1~45 사이의 양의 정수여야 합니다.";

    public static List<Integer> parseWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .filter(number -> {
                    validateWinningNumber(number);
                    return true;
                })
                .map(Integer::parseInt)
                .toList();
    }


    private static void validateWinningNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER);
        }
    }
}
