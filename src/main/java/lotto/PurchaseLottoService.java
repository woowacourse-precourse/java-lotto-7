package lotto;

import java.util.List;

public class PurchaseLottoService implements PurchaseLottoUseCase {

    private static final int UNIT_OF_MONEY = 1000;

    private final LottoFactory lottoFactory;
    private final LottoRepository lottoRepository;

    public PurchaseLottoService(LottoFactory lottoFactory, LottoRepository lottoRepository) {
        this.lottoFactory = lottoFactory;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void purchase(int count) {
        List<Lotto> purchasedLottos = lottoFactory.createByCount(count);
        lottoRepository.saveAll(purchasedLottos);
    }

    @Override
    public int calculatePurchaseCount(int money) {
        return money / UNIT_OF_MONEY;
    }
}
