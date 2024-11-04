package lotto.controller;

import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoInputHandler;
import lotto.service.LottoResultManager;
import lotto.service.LottoResultPrinter;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final LottoGenerator lottoGenerator;
    private final LottoInputHandler lottoInputHandler;
    private final LottoResultPrinter lottoResultPrinter;

    public LottoController(LottoGenerator lottoGenerator, LottoInputHandler lottoInputHandler,
                           LottoResultPrinter lottoResultPrinter) {
        this.lottoGenerator = lottoGenerator;
        this.lottoInputHandler = lottoInputHandler;
        this.lottoResultPrinter = lottoResultPrinter;
    }

    public void startLotto() {
        String inputPurchaseAmount = InputView.getLottoPurchaseAmount();
        int purchaseAmount = ValidateValues.purchaseAmount(inputPurchaseAmount);

        List<Lotto> lottos = lottoGenerator.generateLotto(String.valueOf(purchaseAmount));
        lottoGenerator.printLottoCount(lottos);
        lottoGenerator.printLottos(lottos);

        Lotto winningLotto = lottoInputHandler.getWinningNumbers();
        int bonusNumber = lottoInputHandler.getBonusNumbers();

        lottoResultPrinter.printResult(lottos, winningLotto, bonusNumber);
        lottoResultPrinter.printProfitRate(lottos, winningLotto, bonusNumber, purchaseAmount);
    }

}
