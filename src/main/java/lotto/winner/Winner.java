package lotto.winner;

import java.util.List;
import lotto.lotto.Lotto;

public class Winner {

    private final Lotto winningNumber;

    public Winner(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
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
}