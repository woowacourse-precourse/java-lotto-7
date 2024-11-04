package lotto.service;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.MoneyManagerRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;

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
        List<Lotto> lottos = issueLottos(count);
        List<List<Integer>> allLottoNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();

        return PurchaseLottosResponse.of(count, allLottoNumbers);
    }

    private List<Lotto> issueLottos(Integer count) {
        List<Lotto> lottos = lottoManager.purchaseLotto(count);
        lottos.forEach(lottoRepository::add);
        return lottos;
    }

    public void setWinLottoNumbers(List<Integer> numbers) {
        winLottoRepository.add(new WinLotto(numbers));
    }

    public void setWinLottoBonusNumber(Integer number) {
        WinLotto winLotto = winLottoRepository.getWinLotto();
        winLotto.setBonusNumber(number);
    }

    public getLottoResultResponse getLottoResult() {
        Map<LottoRank, Integer> result = lottoManager.drawResult(lottoRepository.getLottos(), winLottoRepository.getWinLotto());
        MoneyManager moneyManager = moneyManagerRepository.getMoneyManger();
        moneyManager.setPrizeMoney(LottoRank.calculatePrize(result));

        return getLottoResultResponse.of(result, moneyManager.getReturnRate());
    }
}
