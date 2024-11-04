package lotto.valid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static int validatePurchasePrice(String input) {
        int price = parseIntWithValidation(input, "[ERROR] 금액은 숫자로 입력해야 합니다.");
        if (price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        return price;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String s : parts) {
            int number = parseIntWithValidation(s.trim(), "[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
            if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");

            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자를 입력할 수 없습니다.");
            }

            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(String input) {
        int bonusNumber = parseIntWithValidation(input, "[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        if (bonusNumber < 1 || bonusNumber > 45) throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
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
