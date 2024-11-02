package lotto.service;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.MoneyManagerRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private final LottoManager lottoManager;
    private final LottoRepository lottoRepository;
    private final MoneyManagerRepository moneyManagerRepository;
    private final WinLottoRepository winLottoRepository;

    public LottoService(LottoRepository lottoRepository, MoneyManagerRepository moneyManagerRepository, WinLottoRepository winLottoRepository) {
        this.lottoManager = LottoManager.INSTANCE;
        this.lottoRepository = lottoRepository;
        this.moneyManagerRepository = moneyManagerRepository;
        this.winLottoRepository = winLottoRepository;
    }

    public PurchaseLottosResponse purchaseLottos(Long purchaseAmount) {
        moneyManagerRepository.add(new MoneyManager(purchaseAmount));
        Integer count = lottoManager.getPurchasableLottos(purchaseAmount);
        List<Lotto> lottos = lottoManager.purchase(count);
        lottos.forEach(lottoRepository::save);
        List<List<Integer>> allLottoNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();

        return PurchaseLottosResponse.of(count, allLottoNumbers);
    }

    public getLottoResultResponse getLottoResult() {
        WinLotto winLotto = winLottoRepository.getWinLotto();
        List<Lotto> lottos = lottoRepository.getLottos();
        Map<LottoRank, Integer> result = playLotto(lottos, winLotto);
        MoneyManager moneyManager = moneyManagerRepository.getMoneyManger();
        moneyManager.setPrizeMoney(calculatePrizeMoney(result));

        return getLottoResultResponse.of(result, moneyManager.getReturnRate());
    }

    private Map<LottoRank, Integer> playLotto(List<Lotto> lottos, WinLotto winLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();
        lottos.forEach(lotto ->
                result.merge(
                        LottoRank.matchNumbers(lotto, winLotto.getNumbers(), winLotto.getBonusNumber()), 1, Integer::sum
                )
        );
        result.remove(LottoRank.FAIL);

        return result;
    }

    private Long calculatePrizeMoney(Map<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * entry.getKey().getPrize())
                .sum();
    }

    public void setWinLottoNumbers(List<Integer> numbers) {
        winLottoRepository.add(new WinLotto(numbers));
    }

    public void setWinLottoBonusNumber(Integer number) {
        WinLotto winLotto = winLottoRepository.getWinLotto();
        winLotto.setBonusNumber(number);
    }
}
