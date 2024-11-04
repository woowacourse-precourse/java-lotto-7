package lotto.domain;

public class Bonus {
    private static final String SHOULD_INTEGER_MESSAGE = "[ERROR] 보너스 넘버를 숫자로 입력해주세요.";
    private static final String SHOULD_IN_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public Bonus(String rawBonusNumber) {
        int bonusNumber = toInt(rawBonusNumber);
        validateRange(bonusNumber);
        this.number = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(SHOULD_IN_RANGE_MESSAGE);
        }
    }

    private int toInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SHOULD_INTEGER_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
