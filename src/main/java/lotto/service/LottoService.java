package lotto.service;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;

public class LottoService {

    public LottoTicket createLottoTicket(String purchaseMoney) {
        return LottoStore.makeLottoTicket(purchaseMoney);
    }
}
