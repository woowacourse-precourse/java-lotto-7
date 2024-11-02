package lotto.domain;

public class BonusNumber {

    private static final String BONUS_NUMBER_NOT_NATURAL_NUMBER = "[ERROR] 보너스 번호가 자연수가 아닙니다.";
    private static final String BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    private final int number;

    public BonusNumber(String number, WinningNumbers numbers) {
        validate(number, numbers);
        this.number = Integer.parseInt(number);
    }

    private void validate(String number, WinningNumbers numbers) {
        try {
            int bonusNumber = Integer.parseInt(number);
            Lotto.checkNumberRange(bonusNumber);
            checkDuplicatedWithWinningNumbers(bonusNumber, numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NATURAL_NUMBER);
        }
    }

    private void checkDuplicatedWithWinningNumbers(int bonusNumber, WinningNumbers numbers) {
        Lotto winningNumbers = numbers.getNumbers();
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS);
        }
    }

    public int getNumber() {
        return number;
    }
}
