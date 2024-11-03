package lotto;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, WinningNumbers winningNumbers) {
        validate(number, winningNumbers);
        this.number = number;
    }

    private void validate(int number, WinningNumbers winningNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
