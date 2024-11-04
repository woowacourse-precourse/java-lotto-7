package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> Lottos) {
        this.lottoTickets = new ArrayList<>(Lottos);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
