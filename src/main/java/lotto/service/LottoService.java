package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStore;
import lotto.domain.MoneyManager;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.MoneyManagerRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private final LottoStore lottoStore;
    private final LottoRepository lottoRepository;
    private final MoneyManagerRepository moneyManagerRepository;

    public LottoService(LottoRepository lottoRepository, MoneyManagerRepository moneyManagerRepository) {
        this.lottoStore = LottoStore.INSTANCE;
        this.lottoRepository = lottoRepository;
        this.moneyManagerRepository = moneyManagerRepository;
    }

    public PurchaseLottosResponse purchaseLottos(Long purchaseAmount) {
        moneyManagerRepository.add(new MoneyManager(purchaseAmount));
        Integer count = lottoStore.getPurchasableLottos(purchaseAmount);
        List<Lotto> lottos = lottoStore.purchase(count);
        lottos.forEach(lottoRepository::save);
        List<List<Integer>> allLottoNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();

        return PurchaseLottosResponse.of(count, allLottoNumbers);
    }

    public getLottoResultResponse getLottoResult(List<Integer> winLottoNumbers, Integer bonusNumber) {
        Map<LottoRank, Integer> result = new HashMap<>();
        List<Lotto> lottos = lottoRepository.getLottos();
        lottos.forEach(lotto ->
                result.merge(
                        LottoRank.matchNumbers(lotto, winLottoNumbers, bonusNumber), 1, Integer::sum
                )
        );
        result.remove(LottoRank.FAIL);
        MoneyManager moneyManager = moneyManagerRepository.getMoneyManger();
        moneyManager.setPrizeMoney(calculatePrizeMoney(result));
        return getLottoResultResponse.of(result, moneyManager.getReturnRate());
    }

    private Long calculatePrizeMoney(Map<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * entry.getKey().getPrize())
                .sum();
    }
}
