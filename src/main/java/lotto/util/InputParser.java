package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static int parseStringToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int parsePurchaseAmount(String amountInput) {
        return parseStringToInt(amountInput, "[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    public static List<Integer> parseWinningNumbers(String numberInput) {
        return Arrays.stream(numberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String bonusInput) {
        try {
            return Integer.parseInt(bonusInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
