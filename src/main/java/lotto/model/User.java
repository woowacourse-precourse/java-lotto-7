package lotto.model;

import java.util.List;

public class User {
    private final List<Lotto> lottoTickets;
    private final Lotto winnerLotto;
    private final int bonus;

    public User(List<Lotto> lottoTickets, Lotto winnerLotto, int bonus) {
        this.lottoTickets = lottoTickets;
        this.winnerLotto = winnerLotto;
        this.bonus = bonus;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public Lotto getWinnerLotto() {
        return winnerLotto;
    }

    public int getBonus() {
        return bonus;
    }
}
