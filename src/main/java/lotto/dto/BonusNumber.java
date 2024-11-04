package lotto.dto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = validate(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int validate(String bonusNumber) {
        int rawBonusNumber = validateIntegerValue(bonusNumber);
        validateBonusNumberRange(rawBonusNumber);
        return rawBonusNumber;
    }

    public int validateIntegerValue(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이여야 합니다");
        }
    }

    public boolean isBonusNumberMatched(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
