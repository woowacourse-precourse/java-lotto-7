package lotto.domain;

import java.util.List;

public class User {
    private final List<Lotto> lottoTickets;
    private final Lotto winnerLotto;
    private int prize;

    public User(List<Lotto> lottoTickets, Lotto winnerLotto) {
        this.lottoTickets = lottoTickets;
        this.winnerLotto = winnerLotto;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public Lotto getWinnerLotto() {
        return winnerLotto;
    }
}
