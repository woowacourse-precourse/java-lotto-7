package lotto.service.calculator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class WinningCalculator {

    private final List<Integer> winningResult = new ArrayList<>();

    private WinningCalculator(List<Lotto> lottoTicket, Lotto winning) {
        compareTicketToWinning(lottoTicket, winning);
    }

    public static WinningCalculator create(List<Lotto> lottoTicket, Lotto winning) {
        return new WinningCalculator(lottoTicket, winning);
    }

    private void compareTicketToWinning(List<Lotto> lottoTicket, Lotto winning) {
        lottoTicket.forEach(lotto -> countWinning(lotto, winning));
    }

    private void countWinning(Lotto lotto, Lotto winning) {
        winningResult.add((int) lotto.getNumbers().stream()
                .filter(number -> winning.getNumbers().contains(number))
                .count());
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }
}