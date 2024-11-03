package lotto.application.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.application.PurchaseLottoUseCase;
import lotto.domain.repository.LottoRepository;

public class PurchaseLottoService implements PurchaseLottoUseCase {

    private static final int UNIT_OF_MONEY = 1000;

    private final LottoFactory lottoFactory;
    private final LottoRepository lottoRepository;

    public PurchaseLottoService(LottoFactory lottoFactory, LottoRepository lottoRepository) {
        this.lottoFactory = lottoFactory;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void purchase(int money) {
        int purchaseCount = money / UNIT_OF_MONEY;
        List<Lotto> purchasedLottos = lottoFactory.createByCount(purchaseCount);
        lottoRepository.saveAll(purchasedLottos);
    }
}
