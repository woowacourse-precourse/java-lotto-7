package lotto.purchase.service;

import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.port.LottoRepository;
import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.domain.Money;
import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;
import lotto.purchase.service.port.PurchaseRepository;

public class PurchaseServiceImpl implements PurchaseService {

    private final LottoService lottoService;
    private final PurchaseRepository purchaseRepository;
    private final LottoRepository lottoRepository;

    public PurchaseServiceImpl(LottoService lottoService, PurchaseRepository purchaseRepository,
                               LottoRepository lottoRepository) {
        this.lottoService = lottoService;
        this.purchaseRepository = purchaseRepository;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public Purchase createPurchase(long moneyValue) {
        Money money = createMoney(moneyValue);
        LottoResults lottos = lottoService.createLottos(money.getQuantitiesCanBuy());
        Purchase purchase = Purchase.of(lottos.getId(), money);
        purchase = purchaseRepository.save(purchase.getId(), purchase);
        return purchase;
    }

    @Override
    public PurchaseResult getPurchaseResult(String purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId);
        LottoResults lottoResults = lottoRepository.findById(purchase.getLottoResultId());
        return PurchaseResult.of(purchase, lottoResults.calculateTotalWinningAmount(), lottoResults.getWinningInfo());
    }

    private Money createMoney(long money) {
        return Money.of(money);
    }
}
