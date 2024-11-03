package lotto.dto;

import java.util.List;
import lotto.model.LottoBonusNumber;
import lotto.model.Lotto;

public class WinningLottoDTO {

    private final Lotto winningNumbers;
    private final LottoBonusNumber bonusNumber;

    public WinningLottoDTO(Lotto winningNumbers, LottoBonusNumber bonusNumber) {
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
