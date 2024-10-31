package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket purchase(int quantity) {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTicket.add(new Lotto(Lotto.lottoGenerator()));
        }
        return new LottoTicket(lottoTicket);
    }
}
