package lotto.domain;

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
