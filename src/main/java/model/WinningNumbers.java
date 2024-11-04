package model;

import static content.ErrorMessage.WINNING_NUMBERS_OVERLAP;

import content.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String[] winningNumberInput, int bonusNumber) {
        this.winningNumbers = new ArrayList<>();
        for (String number : winningNumberInput) {
            this.winningNumbers.add(Integer.parseInt(number.trim()));
        }
        if (this.winningNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBERS_OVERLAP.getMessage());
        }
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
