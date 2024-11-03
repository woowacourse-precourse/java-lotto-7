package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }

    public int size(){
        return lottoTickets.size();
    }

}
