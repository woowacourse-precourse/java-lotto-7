package lotto.valid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constant.*;

public class InputValidator {
    public static int validatePurchasePrice(String input) {
        int price = parseIntWithValidation(input, String.format(ERROR_NOT_A_NUMBER, "금액은"));
        if (price % 1000 != 0) throw new IllegalArgumentException(ERROR_PRICE_UNIT);
        return price;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String s : parts) {
            int number = parseIntWithValidation(s.trim(), String.format(ERROR_NOT_A_NUMBER, "당첨 번호는"));
            if (number < 1 || number > 45) throw new IllegalArgumentException(ERROR_WINNING_RANGE);

            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS);
            }

            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(String input) {
        int bonusNumber = parseIntWithValidation(input, String.format(ERROR_NOT_A_NUMBER, "보너스 번호는"));
        if (bonusNumber < 1 || bonusNumber > 45) throw new IllegalArgumentException(ERROR_WINNING_RANGE);
        return bonusNumber;
    }

    // 공통 숫자 변환 메서드
    private static int parseIntWithValidation(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
