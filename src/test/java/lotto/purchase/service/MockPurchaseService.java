package lotto.purchase.service;

import java.util.HashMap;
import java.util.Map;
import lotto.lotto.domain.value.LottoRank;
import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.domain.Money;
import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;

public class MockPurchaseService implements PurchaseService {

    @Override
    public Purchase createPurchase(long moneyValue) {
        return Purchase.of("lottoId", Money.of(moneyValue));
    }

    @Override
    public PurchaseResult getPurchaseResult(String purchaseId) {
        Map<LottoRank, Long> winningInfo = new HashMap<>();
        winningInfo.put(LottoRank.MATCHED6, 1L);
        Purchase purchase = Purchase.of("lottoId", Money.of(1000));

        return PurchaseResult.of(purchase, LottoRank.MATCHED6.getValue(), winningInfo);
    }
}
