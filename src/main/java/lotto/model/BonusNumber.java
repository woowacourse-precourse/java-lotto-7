package lotto.model;

public class BonusNumber {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 " + MIN_BONUS_NUMBER + "부터 " + MAX_BONUS_NUMBER + "사이여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return bonusNumber;
    }
}
