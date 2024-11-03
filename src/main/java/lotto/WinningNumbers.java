package lotto;

import java.util.Arrays;

public class WinningNumbers {
    private final int[] winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(int[] winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(int[] numbers, int bonusNumber) {
        if (Arrays.stream(numbers).anyMatch(num -> num == bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean contains(int number) {
        return Arrays.stream(winningNumbers).anyMatch(num -> num == number);
    }
}

