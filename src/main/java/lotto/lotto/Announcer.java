package lotto.lotto;

import java.util.List;

public class Announcer {

    private final WinningNumber winningNumber;

    public Announcer(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Prize> compareLottoResult(List<Lotto> tickets) {
        return tickets.stream()
                .map(ticket -> ticket.compare(winningNumber))
                .toList();
    }

}
