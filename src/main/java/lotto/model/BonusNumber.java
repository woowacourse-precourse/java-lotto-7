package lotto.model;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input, WinningNumbers winningNumbers) {
        this.number = parseAndValidate(input, winningNumbers);
    }

    private int parseAndValidate(String input, WinningNumbers winningNumbers) {
        try {
            int number = Integer.parseInt(input.trim());
            validateNumber(number, winningNumbers);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateNumber(int number, WinningNumbers winningNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
