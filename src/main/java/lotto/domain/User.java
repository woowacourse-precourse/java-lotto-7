package lotto.domain;

import java.util.List;

public class UserLotto {
    private final List<Lotto> lottoTickets;
    private final Lotto winnerLotto;
    private int total;

    public UserLotto(List<Lotto> lottoTickets, Lotto winnerLotto) {
        this.lottoTickets = lottoTickets;
        this.winnerLotto = winnerLotto;
    }

}
