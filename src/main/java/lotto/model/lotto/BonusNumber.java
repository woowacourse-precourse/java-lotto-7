package lotto.model.lotto;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonus;

    public BonusNumber(final String bonusNumber) {
        int bonus = convertToInt(bonusNumber);
        validateRange(bonus);
        this.bonus = bonus;
    }

    private int convertToInt(final String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void validateRange(final int bonus) {
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    protected int getBonus() {
        return bonus;
    }
}
