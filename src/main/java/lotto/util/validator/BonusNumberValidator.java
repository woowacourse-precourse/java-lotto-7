package lotto.util.validator;

import java.util.List;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateInput(input);

        try {
            int bonusNumber = Integer.parseInt(input.trim());

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(
                        "[ERROR] 보너스 번호는 1~45 범위 내의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalStateException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어 있습니다.");
        }
    }
}
