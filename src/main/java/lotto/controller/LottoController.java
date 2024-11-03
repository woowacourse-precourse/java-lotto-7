package lotto.controller;

import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultManager;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final LottoGenerator lottoGenerator;
    private final LottoResultManager lottoResultManager;

    public LottoController(LottoGenerator lottoGenerator, LottoResultManager lottoResultManager) {
        this.lottoGenerator = lottoGenerator;
        this.lottoResultManager = lottoResultManager;
    }

    public void startLotto() {
        String inputPurchaseAmount = InputView.getLottoPurchaseAmount();
        int purchaseAmount = ValidateValues.purchaseAmount(inputPurchaseAmount);
        int count = purchaseAmount / 1000;

        List<Lotto> lottos = lottoGenerator.generateLotto(count);
        lottoGenerator.printLottoCount(lottos);
        lottoGenerator.printLottos(lottos);

        List<Integer> winningNumbers = lottoResultManager.getWinningNumbers();
        int bonusNumber = lottoResultManager.getBonusNumbers();

        lottoResultManager.printResult(lottos, winningNumbers, bonusNumber);
    }

}
