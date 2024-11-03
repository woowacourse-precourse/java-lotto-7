package lotto.validator;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    public static void validatePurchase(int lottoAmount) {
        validateAmount(lottoAmount);
    }

    public static void validateAmount(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (lottoAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1원 이상의 양수로 입력해야 합니다.");
        }
        if (lottoAmount > 1000000000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 큽니다. 다시 입력해 주세요.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validatePurchaseStringInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있을 수 없습니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumberInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있을 수 없습니다.");
        }
        String[] numbers = input.split(",");
        if (numbers.length != 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
        }
        try {
            int bonusNumber = Integer.parseInt(numbers[0]);
            validateBonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

}
