package lotto.util;

import java.util.List;

public class InputValidator {

    public static void validatePurchaseAmount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void validateBonusNumberRange(int bonus) {
        if (bonus < 0 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumber(String input) {
        if (input.indexOf(",") == 0 || input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력이 잘못되었습니다.");
        }
    }

    public static void checkBonusNumberDuplicates(List<Integer> winningNumbers ,int bonus) {
        for (Integer number : winningNumbers) {
            if (number == bonus) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
            }
        }
    }
}
