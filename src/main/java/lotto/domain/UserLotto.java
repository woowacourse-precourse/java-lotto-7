package lotto.domain;

import java.util.List;

public class UserLotto {
    private final List<Lotto> lottoTickets;
    private int total;

    public UserLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

}
