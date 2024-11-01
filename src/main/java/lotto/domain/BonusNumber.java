package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(String bonusNumber) {
        Validator.validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public static BonusNumber from(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {

        private static void validateBonusNumber(String bonusNumber) {
            validateWinningNumbersIsNotEmpty(bonusNumber);
        }

        private static void validateWinningNumbersIsNotEmpty(String bonusNumber) {
            if (bonusNumber == null || bonusNumber.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 비어있을 수 없습니다.");
            }
        }

    }

}