package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {

        int purchasePrice = Integer.parseInt(InputView.inputPurchasePrice());

        LottoStore lottoStore = new LottoStore();
        lottoStore.buyLotto(purchasePrice);

        OutputView.printPurchasedLottoAmount(lottoStore.getLottos().size());
        OutputView.printPurchasedLottoNumbers(lottoStore.getLottos());

        List<Integer> winNumbers = Arrays.stream(InputView.inputWinNumbers().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int bonusNumber = Integer.parseInt(InputView.inputBonusNumber());

        LottoMachine lottoMachine = new LottoMachine(winNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoStore.getLottos(), winNumbers, bonusNumber);
        lottoResult.calculateProfitRate(purchasePrice);

        Map<LottoRank, Integer> lottoResultDetail = lottoResult.getLottoResult();

        OutputView.printWinStatistics();
        lottoResultDetail.forEach((k, v) -> {
            OutputView.printWinStatisticsDetail(k.getMessage(), v);
        });

        OutputView.printProfitRate(lottoResult.getProfitRate());
    }

}
