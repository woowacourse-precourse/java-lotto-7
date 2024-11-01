package lotto.dto;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class WinningLottoDTO {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLottoDTO(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
