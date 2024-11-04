package lotto.domain.winning;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumbers = new ArrayList<>();
    private final String winningNumbersString;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbersString, int bonusNumber) {
        this.winningNumbersString = winningNumbersString;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        for (String number : winningNumbersString.split(",")) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public int getBonus() {
        return bonusNumber;
    }
}
