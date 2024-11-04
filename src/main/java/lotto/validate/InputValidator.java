package lotto.validate;

import java.util.List;
import lotto.domain.Lotto;

public class InputValidator {

    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 큰 수여야 합니다.");
        }
        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주어야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        new Lotto(winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 " + BONUS_NUMBER_MIN + "부터 " + BONUS_NUMBER_MAX + " 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복된 숫자가 입력되면 안됩니다.");
        }
    }
}
