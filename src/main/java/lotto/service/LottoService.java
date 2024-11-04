package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPayment;
import lotto.strategy.IssuanceStrategy;

public class LottoService {
    public List<Lotto> purchaseAll(LottoPayment lottoPayment, IssuanceStrategy issuanceStrategy) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoPayment.hasSufficientAmount()) {
            Lotto lotto = purchase(lottoPayment, issuanceStrategy);
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto purchase(LottoPayment lottoPayment, IssuanceStrategy issuanceStrategy) {
        lottoPayment.deductSingleTicket();
        return issuanceStrategy.issue();
    }
}
