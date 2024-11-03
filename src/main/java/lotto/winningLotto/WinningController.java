package lotto.winningLotto;

import java.util.List;
import lotto.publishingLotto.model.Lotto;

public class WinningController {
    private final List<Lotto> LottoTickets;

    public WinningController(List<Lotto> lottoTickets) {
        LottoTickets = lottoTickets;
    }
}
