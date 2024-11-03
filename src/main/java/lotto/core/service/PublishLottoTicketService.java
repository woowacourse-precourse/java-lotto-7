package lotto.core.service;

import java.util.ArrayList;
import java.util.List;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.model.Lotto;
import lotto.core.model.LottoPurchaseAmount;
import lotto.core.model.LottoTicket;

public class PublishLottoTicketService {

    public LottoTicketDto publish(LottoPurchaseAmountDto amount) {
        int count = amount.lottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = createLottoUntilSuccess();
            lottos.add(lotto);
        }
        LottoTicket ticket = new LottoTicket(LottoPurchaseAmount.dtoOf(amount), lottos);
        return LottoTicketDto.modelOf(ticket);
    }

    private Lotto createLottoUntilSuccess() {
        while (true) {
            Lotto lotto = this.createLotto();
            if (lotto != null) return lotto;
        }
    }

    private Lotto createLotto() {
        try {
            return Lotto.newRandomNumbers();
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }
}
