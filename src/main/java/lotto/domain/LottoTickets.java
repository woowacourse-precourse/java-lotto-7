package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<Lotto> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 티켓 목록은 비어 있을 수 없습니다.");
        }
        return new LottoTickets(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }

    public int size(){
        return lottoTickets.size();
    }
}
