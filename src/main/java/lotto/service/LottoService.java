package lotto.service;

import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.PurchasedLottos;
import lotto.domain.lottomachine.AutoNumberGenerator;
import lotto.domain.lottomachine.LottoMachine;
import lotto.dto.response.LottosResponse;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottosResponse purchaseLottos(Integer purchaseAmount) {
        Money money = Money.from(purchaseAmount);
        LottoStore lottoStore = new LottoStore();

        int quantity = lottoStore.calculateLottoQuantity(money);
        PurchasedLottos purchasedLottos = lottoMachine.issueTickets(new AutoNumberGenerator(), quantity);

        return LottosResponse.of(
                quantity,
                purchasedLottos
        );
    }
}
