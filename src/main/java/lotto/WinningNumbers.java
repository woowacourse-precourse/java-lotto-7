package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {

        String winningNumbersString = convertListToString(winningNumbers);
        Validation.validateWinningNumbers(winningNumbersString);

        String bonusNumberString = String.valueOf(bonusNumber);
        Validation.validateBonusNumber(bonusNumberString, winningNumbers);

        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    private String convertListToString(List<Integer> numbers) {
        return String.join(",", numbers.stream().map(String::valueOf).toArray(String[]::new));
    }
}
