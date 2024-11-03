package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<Lotto>();

    public LottoTickets(List<List<Integer>> tickets) {
        for (List<Integer> lotto : tickets) {
            lottoTickets.add(new Lotto(lotto));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
