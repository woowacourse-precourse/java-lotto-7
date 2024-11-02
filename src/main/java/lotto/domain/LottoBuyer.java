package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private final List<Lotto> lottoTickets;

    public LottoBuyer(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void buyLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }


}
