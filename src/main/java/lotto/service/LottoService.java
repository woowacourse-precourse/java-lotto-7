package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;

public class LottoService {
    private final LottoStore lottoStore;

    public LottoService() {
        this.lottoStore = new LottoStore();
    }

    public LottoTickets purchaseLottoTickets(int amount){
        LottoPurchase purchase = LottoPurchase.of(amount);
        return lottoStore.generateLottoTickets(purchase.getTicketCount());
    }
}
