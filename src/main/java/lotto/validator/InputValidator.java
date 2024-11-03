package lotto.validator;

import java.util.List;
import lotto.exception.InputException;

public class InputValidator {
    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputException("[ERROR] 구입금액은 정수여야 합니다.");
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 != 0) {
            throw new InputException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
        return purchaseAmountInt;
    }

    public static List<Integer> validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new InputException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new InputException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new InputException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }
}
