package lotto.model;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumberString, WinningNumber winningNumber) {
        validateNotEmpty(bonusNumberString);
        validateNumberIsInteger(bonusNumberString);
        this.bonusNumber = Integer.parseInt(bonusNumberString);
        validateNumberRange();
        validateNoDuplicate(winningNumber);
    }

    private void validateNotEmpty(String bonusNumberString) {
        if (bonusNumberString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 빈 값이 들어올 수 없습니다.");
        }
    }

    private void validateNumberIsInteger(String bonusNumberString) {
        try {
            Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력되어야 합니다.");
        }
    }

    private void validateNumberRange() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicate(WinningNumber winningNumber) {
        if (winningNumber.isContainsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 없이 입력되어야 합니다.");
        }
    }

    public boolean isContainsNumber(int number) {
        return bonusNumber == number;
    }
}
