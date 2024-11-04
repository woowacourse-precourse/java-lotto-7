package lotto.lotto;

import java.util.List;

public class Announcer {

    private final WinningNumber winningNumber;
    private final int bonusNumber;

    public Announcer(WinningNumber winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Prize> compareLottoResult(List<Lotto> tickets) {
        return tickets.stream()
                .map(ticket -> ticket.compare(winningNumber, bonusNumber))
                .toList();
    }

}
