package lotto.domain;

public class BonusNumber {

    private final Number bonusNumber;

    private BonusNumber(WinningNumbers winningNumbers, Number number) {
        Validator.validate(winningNumbers, number);
        this.bonusNumber = number;
    }

    public static BonusNumber valueOf(WinningNumbers winningNumbers, Number number) {
        return new BonusNumber(winningNumbers, number);
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {
        private static void validate(WinningNumbers winningNumbers, Number number) {
            if (isBonusNumberInWinningNumbers(winningNumbers, number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함된 숫자는 입력할 수 없습니다.");
            }
        }

        private static boolean isBonusNumberInWinningNumbers(WinningNumbers winningNumbers,
                                                             Number number) {
            return winningNumbers.contains(number);
        }
    }
}
