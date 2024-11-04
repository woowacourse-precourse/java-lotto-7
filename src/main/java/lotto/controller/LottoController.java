package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoProcessor;
import lotto.model.LottoType;
import lotto.utils.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoProcessor lottoProcessor;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoProcessor lottoProcessor, InputView inputView, OutputView outputView) {
        this.lottoProcessor = lottoProcessor;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void lottoProcess() {
        int purchaseAmount = inputView.enterPurchaseAmount();
        outputView.printPurchaseNumber(purchaseAmount);

        List<List<Integer>> purchaseLottoNumbers = LottoUtils.generate(purchaseAmount);
        outputView.PrintPurchaseHistory(purchaseLottoNumbers);

        Lotto lotto = inputView.enterWinningNumbers();
        int inputBonusNumber = inputView.enterBonusNumber();

        Map<LottoType, Integer> lottoPickResult = lottoProcessor.lottoPick(purchaseLottoNumbers, lotto, inputBonusNumber);
        outputView.printWinningStatistics(lottoPickResult);
        outputView.printTotalReturn(lottoProcessor, purchaseAmount);
    }
}
