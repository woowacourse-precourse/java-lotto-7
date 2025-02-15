package lotto.dto;

import java.util.List;

public class LottoWinningNumbersDTO {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbersDTO(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
