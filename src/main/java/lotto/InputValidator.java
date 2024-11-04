package lotto;

import java.util.List;

public class InputValidator {

    private static final String LOTTO_FORMAT_REGEX = "^(\\d{1,2})(,\\d{1,2}){5}$";

    public static void validatePrice(String purchasePrice) {
        validateEmptyInput(purchasePrice, "구입 금액");
        int price = validateNumber(purchasePrice, "구입 금액");
        if (price <= 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void validateWinningNum(String winningNumInput) {
        validateEmptyInput(winningNumInput, "당첨 번호");
        validateNumFormat(winningNumInput);
    }

    public static void validateBonusNum(String bonusNumInput) {
        validateEmptyInput(bonusNumInput, "보너스 번호");
        validateRange(bonusNumInput.trim());
    }

    public static void validateBonusNumUnique(int bonusNum, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateEmptyInput(String input, String fieldName) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + fieldName + "은(는) 비어 있을 수 없습니다.");
        }
    }

    private static int validateNumber(String input, String fieldName) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + fieldName + "은(는) 숫자로 입력해야 합니다.");
        }
    }

    private static void validateRange(String input) {
        int number = validateNumber(input, "보너스 번호");
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNumFormat(String winningNumInput) {
        if (!winningNumInput.matches(LOTTO_FORMAT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자로 입력해야 합니다.");
        }
    }
}
