package lotto.domain;

public record BonusNumber(int bonusNumber) {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;

    public BonusNumber {
        validateWinningNumber(bonusNumber);
    }

    private void validateWinningNumber(int bonusNumber) {
        if (bonusNumber < MIN_RANDOM_NUMBER || bonusNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}
