package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private final LottoGenerator lottoGenerator;
    private final PurchaseAmount purchaseAmount;

    public LottoTicketGenerator(LottoGenerator lottoGenerator, PurchaseAmount purchaseAmount) {
        this.lottoGenerator = lottoGenerator;
        this.purchaseAmount = purchaseAmount;
    }

    public LottoTicket generateLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = purchaseAmount.getPurchasableLottoAmount();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return new LottoTicket(lottos);
    }

}
