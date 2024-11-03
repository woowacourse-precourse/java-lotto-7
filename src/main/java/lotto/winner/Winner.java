package lotto.winner;

import java.util.List;
import lotto.lotto.Lotto;

public class Winner {

    private final Lotto winningNumber;
    private final int bonusNumber;

    public Winner(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public int determineLottoRank(Lotto lotto) {
        return (int) getWinningNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}