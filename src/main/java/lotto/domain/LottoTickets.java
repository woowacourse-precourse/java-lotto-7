package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets generateLottoTickets(int count){
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(Lotto.generateLotto());
        }

        return new LottoTickets(tickets);
    }

    public List<List<Integer>> getLottoTickets() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return List.copyOf(lottoNumbers);
    }

}
