package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<List<Integer>> getLottoTickets() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return List.copyOf(lottoNumbers);
    }

}
