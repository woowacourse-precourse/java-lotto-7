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

        List<Lotto> lottos = lottoGenerator.generateLotto(inputPurchaseAmount);
        lottoGenerator.printLottoCount(lottos);
        lottoGenerator.printLottos(lottos);

        Lotto winningLotto = lottoResultManager.getWinningNumbers();
        int bonusNumber = lottoResultManager.getBonusNumbers();

        lottoResultManager.printResult(lottos, winningLotto, bonusNumber);
        lottoResultManager.printProfitRate(lottos, winningLotto, bonusNumber, purchaseAmount);

    }

}
