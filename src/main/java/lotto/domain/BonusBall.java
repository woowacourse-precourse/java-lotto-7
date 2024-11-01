package lotto.domain;

import java.util.List;

public class BonusBall {
    private final int number;

    public BonusBall (int number, List<Integer> winningNumbers) {
        validateNumberRange(number);
        validateNoDuplicateWithWinningNumbers(number, winningNumbers);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicateWithWinningNumbers(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return number;
    }
}
