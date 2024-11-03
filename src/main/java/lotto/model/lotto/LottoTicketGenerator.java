package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private final LottoGenerator lottoGenerator;
    // lottoGenerator 부분을 리펙토링 할 경우 전략패턴 등 다양하게 시도가 가능할 것 같음
    public LottoTicketGenerator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }
    // lottoGenerator 를 통해 생성된 로또를 구입 개수 만큼 생성하고 이를 티켓에 저장!
    public LottoTicket generateLottoTicket(PurchaseAmount purchaseAmount) {
        List<Lotto> ticket = new ArrayList<>();
        int lottoAmount = purchaseAmount.getPurchasableLottoAmount();
        for (int i = 0; i < lottoAmount; i++) {
            ticket.add(lottoGenerator.generateLotto());
        }
        return new LottoTicket(ticket);
    }

}
