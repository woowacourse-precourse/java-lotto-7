package lotto.util;

import java.util.List;

public class InputValidator {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static void validatePurchaseAmount(String inputPurchaseAmount) {
        int amount = parseAmount(inputPurchaseAmount);
        checkLottoPrice(amount);
    }

    private static int parseAmount(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void checkLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위어야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        checkWinningNumberCount(numbers);
        checkWinningNumberDuplication(numbers);
        checkWinningNumberRange(numbers);
    }

    private static void checkWinningNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private static void checkWinningNumberDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private static void checkWinningNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        checkBonusNumberRange(bonusNumber);
        checkBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이여야 합니다.");
        }
    }

    private static void checkBonusNumberNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

}
