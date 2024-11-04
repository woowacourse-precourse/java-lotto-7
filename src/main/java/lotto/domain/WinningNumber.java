package lotto.domain;

public record WinningNumber(int winningNumber) {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;

    public WinningNumber {
        validateWinningNumber(winningNumber);
    }

    private void validateWinningNumber(int winningNumber) {
        if (winningNumber < MIN_RANDOM_NUMBER || winningNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}
