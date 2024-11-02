package lotto.model;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<List<Integer>> getLottoTicketNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
