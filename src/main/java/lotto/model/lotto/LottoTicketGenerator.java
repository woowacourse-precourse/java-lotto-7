package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private final LottoGenerator lottoGenerator;

    public LottoTicketGenerator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket generateLottoTicket(PurchaseAmount purchaseAmount) {
        List<Lotto> ticket = new ArrayList<>();
        int lottoAmount = purchaseAmount.getPurchasableLottoAmount();
        for (int i = 0; i < lottoAmount; i++) {
            ticket.add(lottoGenerator.generateLotto());
        }
        return new LottoTicket(ticket);
    }

}
