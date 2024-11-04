package lotto.service;

import java.util.HashSet;
import java.util.List;

public class ValidationService {

    static int MINIMUM_BUDGET_UNIT = 1000;
    private final static String ERROR_BUDGET_IS_NOT_GREATER_THAN_ZERO_DESC = "[ERROR] 구매 금액은 자연수여야 합니다.";
    private final static String ERROR_BUDGET_IS_NOT_MULTIPLE_OF_1000 = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private final static int WINNING_NUMBER_SIZE = 6;
    private final static int MINIMUM_WINNING_NUMBER = 1;
    private final static int MAXIMUM_WINNING_NUMBER = 45;

    // 유효성 검사: 구입 금액이 자연수이고 1,000으로 나누어 떨어지는지 확인
    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_IS_NOT_GREATER_THAN_ZERO_DESC);
        }
        if (purchaseAmount % MINIMUM_BUDGET_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_IS_NOT_MULTIPLE_OF_1000);
        }
    }

    // 유효성 검사: 당첨 번호가 유효한지 확인
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.");
        }
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_WINNING_NUMBER || winningNumber > MAXIMUM_WINNING_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.");
            }
        }
        if (new HashSet<>(winningNumbers).size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.");
        }
    }

    // 유효성 검사: 보너스 번호가 당첨 번호와 중복되지 않는지 확인
    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
