package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(String bonusNumber) {
        this.bonusNumber = Validator.validateBonusNumber(bonusNumber);
    }

    public static BonusNumber from(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {

        private static final String BONUS_NUMBER_NUMERIC_REGEX = "-?\\d+";
        private static final int MINIMUM_WINNING_NUMBER = 1;
        private static final int MAXIMUM_WINNING_NUMBER = 45;

        private static int validateBonusNumber(String bonusNumber) {
            validateWinningNumbersIsNotEmpty(bonusNumber);
            int numericBonusNumber = validateBonusNumberIsNumeric(bonusNumber);
            validateBonusNumberInRange(numericBonusNumber);
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

    }

}