package lotto.domain;

import java.util.List;
import lotto.utils.Parser;

public class WinningLottoNumber {

    private Lotto winningNumber;
    private BonusNumber bonusNumber;

    public WinningLottoNumber(Lotto winningNumber, String bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = Parser.parseBonusNumber(bonusNumber, this.winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonus();
    }
}
