package lotto.util;

import java.util.List;
import java.util.Set;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validatePurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력할 수 있습니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 정확히 6개여야 합니다.");
        }
        for (int num : winningNumbers) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력할 수 있습니다.");
        }
        int bonus = Integer.parseInt(input);
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}