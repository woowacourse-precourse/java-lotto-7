package lotto.lotto;

import lotto.lotto.value.Lotto;
import lotto.lotto.value.Prize;
import lotto.lotto.value.WinningNumber;

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
