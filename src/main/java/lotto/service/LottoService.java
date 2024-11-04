package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicket;

public class LottoService {
    public LottoTicket purchase(int quantity) {
        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < quantity; i++) {
            lottoTicket.lottoAdd(new Lotto(Lotto.lottoGenerator()));
        }
        return lottoTicket;
    }
}
