package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class WinningLotto {
    private final LottoTicket winningTicket;

    public WinningLotto(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public int countMatchingNumbersWith(Lotto purchasedLotto) {
        Lotto winningLotto = winningTicket.lottos().getFirst();
        return winningLotto.countMatchingNumbersWith(purchasedLotto);
    }
}
