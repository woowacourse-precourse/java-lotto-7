package lotto;

import static lotto.Lotto.*;

public class InputValidator {
    static void validatePurchaseAmount(String input) {
        checkNumberIsPositive(input);
        check1000WonUnits(input);
    }

    static int validateBonusNumber(String input, Lotto winningLotto) {
        checkNumberIsPositive(input);
        int bonusNumber = Integer.parseInt(input.trim());
        checkBonusNumberIsLowerThan45(bonusNumber);
        checkDuplicates(winningLotto, bonusNumber);

        return bonusNumber;
    }

    private static void checkNumberIsPositive(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }
    }

    private static void check1000WonUnits(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.");
        }
    }

    private static void checkDuplicates(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");
        }
    }

    private static void checkBonusNumberIsLowerThan45(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
