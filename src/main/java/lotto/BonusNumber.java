package lotto;

public class BonusNumber {
	private final int number;

    public BonusNumber(String input, WinningNumber winningNumber) {
        this.number = parseAndValidate(input, winningNumber);
    }

    private int parseAndValidate(String input, WinningNumber winningNumber) {
        int number = parseNumber(input);
        validateRange(number);
        validateDuplication(number, winningNumber);
        return number;
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(int number, WinningNumber winningNumber) {
        if (winningNumber.getLotto().getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
