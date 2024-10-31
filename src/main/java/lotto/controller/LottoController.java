package lotto.controller;


import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {

        int purchasePrice = Integer.parseInt(InputView.inputPurchasePrice());

        LottoStore lottoStore = new LottoStore();
        lottoStore.buyLotto(purchasePrice);

        OutputView.printPurchasedLottoAmount(lottoStore.getPurchasedLottos().size());
        OutputView.printPurchasedLottoNumbers(lottoStore.getPurchasedLottos());

        Numbers winNumbers = new Numbers(InputView.inputWinNumbers());
        Number bonusNumber = new Number(InputView.inputBonusNumber());

        if (winNumbers.contains(bonusNumber)) return ;//보너스 관련 로직 추가 필요;

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoStore.getPurchasedLottos(), winNumbers, bonusNumber);
        lottoResult.calculateProfitRate(purchasePrice);

        Map<LottoRank, Integer> lottoResultDetail = lottoResult.getLottoResult();

        OutputView.printWinStatistics();
        lottoResultDetail.forEach((k, v) -> {
            OutputView.printWinStatisticsDetail(k.getMessage(), v);
        });

        OutputView.printProfitRate(lottoResult.getProfitRate());
    }

}
