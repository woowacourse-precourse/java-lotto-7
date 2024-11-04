package lotto;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String bonusNumberInput) {
        validateBonusNumberIsInteger(bonusNumberInput);
        validateRangeOfBonusNumber(Integer.parseInt(bonusNumberInput));
        return new BonusNumber(Integer.parseInt(bonusNumberInput));
    }

    private static void validateBonusNumberIsInteger(String bonusNumberInput) {
        boolean isInteger = bonusNumberInput.chars().allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 입력값은 양의 정수여야 합니다.");
        }
    }

    private static void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < Constants.LOTTO_NUMBER_MIN || bonusNumber > Constants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
