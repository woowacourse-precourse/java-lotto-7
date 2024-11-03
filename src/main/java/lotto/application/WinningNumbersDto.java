package lotto.application;

import java.util.List;

public class WinningNumbersDto {
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningNumbersDto(List<Integer> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
