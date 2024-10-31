package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.repository.LottoRepository;
import lotto.dto.response.PurchaseLottosResponse;

import java.util.List;

public class LottoService {

    private final LottoStore lottoStore;
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoStore = LottoStore.INSTANCE;
        this.lottoRepository = lottoRepository;
    }

    public PurchaseLottosResponse purchaseLottos(Integer purchaseAmount) {
        Integer count = lottoStore.getMaxPurchasableLottos(purchaseAmount);
        List<Lotto> lottos = lottoStore.purchase(count);
        lottos.forEach(lottoRepository::save);
        List<List<Integer>> allLottoNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();

        return PurchaseLottosResponse.of(count, allLottoNumbers);
    }
}
