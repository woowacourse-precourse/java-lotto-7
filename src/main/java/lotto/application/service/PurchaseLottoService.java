package lotto.application.service;

import static lotto.common.LottoConstant.UNIT_OF_MONEY;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.application.PurchaseLottoUseCase;
import lotto.domain.Money;
import lotto.domain.repository.LottoRepository;

public class PurchaseLottoService implements PurchaseLottoUseCase {

    private final LottoFactory lottoFactory;
    private final LottoRepository lottoRepository;

    public PurchaseLottoService(LottoFactory lottoFactory, LottoRepository lottoRepository) {
        this.lottoFactory = lottoFactory;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void purchase(Money money) {
        int purchaseCount = money.amount().intValue() / UNIT_OF_MONEY;
        List<Lotto> purchasedLottos = lottoFactory.createByCount(purchaseCount);
        lottoRepository.saveAll(purchasedLottos);
    }
}
