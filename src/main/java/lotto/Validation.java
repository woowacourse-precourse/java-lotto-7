package lotto;

import java.util.Arrays;

public class Validation {
    private static final int LOTTO_COST = 1000;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;

    public static void validateMoney(String money) {
        if (isNotInteger(money)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(money) % LOTTO_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_COST + " 단위여야 합니다.");
        }
    }

    public static void validateWinningNumber(String[] winningNumberString) {
        boolean containsNonNumeric = Arrays.stream(winningNumberString)
                .anyMatch(Validation::isNotInteger);
        if (containsNonNumeric) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }

        boolean containsOutOfRange = Arrays.stream(winningNumberString)
                .anyMatch(Validation::isNotInRange);
        if (containsOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45까지 입력 가능합니다.");
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (isNotInteger(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (isNotInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45까지 입력 가능합니다.");
        }
    }

    public static boolean isNotInteger(String num) {
        try {
            Integer.parseInt(num);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isNotInRange(String num) {
        return Integer.parseInt(num) < NUM_MIN || Integer.parseInt(num) > NUM_MAX;
    }
}
