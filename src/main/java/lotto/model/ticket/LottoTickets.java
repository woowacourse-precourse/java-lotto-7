package lotto.model.ticket;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getCount() {
        return lottoTickets.size();
    }

    public List<List<Integer>> getAllNumbers() {
        return lottoTickets.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
