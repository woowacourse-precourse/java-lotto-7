package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<List<Integer>> lottoTickets;

    public LottoTickets(int ticket) {
        this.lottoTickets = new ArrayList<>();
    }

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }
}
