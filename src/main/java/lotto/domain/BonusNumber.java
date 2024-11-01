package lotto.domain;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(List<Integer> winningNumber, String bonusNumber) {
        this.bonusNumber = Validator.validateBonusNumber(winningNumber, bonusNumber);
    }

    public static BonusNumber of(List<Integer> winningNumber, String bonusNumber) {
        return new BonusNumber(winningNumber, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {

        private static final String BONUS_NUMBER_NUMERIC_REGEX = "-?\\d+";
        private static final int MINIMUM_WINNING_NUMBER = 1;
        private static final int MAXIMUM_WINNING_NUMBER = 45;

        private static int validateBonusNumber(List<Integer> winningNumber, String bonusNumber) {
            validateWinningNumbersIsNotEmpty(bonusNumber);
            int numericBonusNumber = validateBonusNumberIsNumeric(bonusNumber);
            validateBonusNumberInRange(numericBonusNumber);
            validateUniqueBonusAndWinningNumbers(winningNumber, numericBonusNumber);
            return numericBonusNumber;
        }

        private static void validateWinningNumbersIsNotEmpty(String bonusNumber) {
            if (bonusNumber == null || bonusNumber.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 비어있을 수 없습니다.");
            }
        }

        private static int validateBonusNumberIsNumeric(String bonusNumber) {
            if (!bonusNumber.matches(BONUS_NUMBER_NUMERIC_REGEX)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
            }
            return Integer.parseInt(bonusNumber);
        }

        private static void validateBonusNumberInRange(int bonusNumber) {
            if (bonusNumber < MINIMUM_WINNING_NUMBER || bonusNumber > MAXIMUM_WINNING_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력 가능합니다.");
            }
        }

        private static void validateUniqueBonusAndWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
            for (int winningNumber : winningNumbers) {
                if (winningNumber == bonusNumber) {
                    throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
                }
            }
        }

    }

}