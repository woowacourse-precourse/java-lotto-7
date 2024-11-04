package lotto.controller;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.LottoPrizes;
import lotto.model.domain.Lottos;
import lotto.model.domain.ProfitRatio;
import lotto.model.domain.PurchaseAmount;
import lotto.util.UIExecutor;
import lotto.model.domain.LottoWinning;
import lotto.model.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";
    private final UIExecutor uiExecutor;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(UIExecutor uiExecutor, InputView inputView, OutputView outputView, LottoService lottoService) {
        this.uiExecutor = uiExecutor;
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = uiExecutor.execute(input -> getPurchaseAmount(), null);

        Lottos lottos = uiExecutor.execute(input -> purchaseLotto(purchaseAmount), purchaseAmount);

        LottoWinning winningNumbers = uiExecutor.execute(input -> getWinningNumbers(), null);

        LottoPrizes winners = lottoService.drawWinners(lottos, winningNumbers);

        printResult(purchaseAmount, winners);

        inputView.close();
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printPurchaseAmountRequest();
        return inputView.getPurchaseAmount();
    }

    private Lottos purchaseLotto(PurchaseAmount purchaseAmount) {
        Lottos lottos = lottoService.createLottos(purchaseAmount);
        outputView.printPurchaseLotto(lottos);
        return lottos;
    }

    private LottoWinning getWinningNumbers() {
        outputView.printWinningNumbersRequest();
        List<Integer> winningNumbers = inputView.getWinningNumbers(DELIMITER);
        outputView.printBonusNumberRequest();
        BonusNumber bonusNumber = inputView.getBonusNumber();
        return new LottoWinning(winningNumbers, bonusNumber);
    }

    private void printResult(PurchaseAmount purchaseAmount, LottoPrizes prizes) {
        ProfitRatio profitRatio = lottoService.getProfitRatio(purchaseAmount, prizes);
        outputView.printWinningReport(prizes);
        outputView.printProfitRatio(profitRatio);
    }
}
