package lotto.validator;

import java.util.List;

public class InputValidator {

    public static void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount == null) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 null입니다.");
        }
        try {
            int amount = Integer.parseInt(purchaseAmount);
            if (amount < 1000) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 null입니다.");
        }
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateNoOverlap(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public static void validateWinningNumbersString(String winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력이 null입니다.");
        }
        for (String number : winningNumbers.split(",")) {
            try {
                Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 숫자와 구분자만 포함되어야 합니다.");
            }
        }
    }

    public static void validateBonusNumberString(String bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 null입니다.");
        }
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}