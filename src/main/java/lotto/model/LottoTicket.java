package lotto.model;

public class LottoTicket {
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int countMatchingNumber(WinningLotto winningLotto) {
        return lotto.countMatchingNumber(winningLotto);
    }
}
