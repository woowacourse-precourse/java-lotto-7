package lotto.controller;

import lotto.ApplicationConfig;
import lotto.dto.LottoResult;
import lotto.dto.LottoTickets;
import lotto.model.LottoIssuer;
import lotto.model.LottoResultCalculator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.io.InputHandler;
import lotto.io.OutputView;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final LottoIssuer lottoIssuer;

    public LottoController(final ApplicationConfig applicationConfig) {
        this.inputHandler = applicationConfig.inputHandler();
        this.outputView = applicationConfig.outputView();
        this.lottoIssuer = applicationConfig.lottoIssuer();
    }

    public void execute() {
        PurchaseAmount purchaseAmount = inputHandler.readPurchaseAmount();
        LottoTickets lottoTickets = issueLottoTickets(purchaseAmount);
        printPurchaseResult(lottoTickets);
        WinningLotto winningLotto = inputHandler.readWinningLotto();
        LottoResult lottoResult = getLottoResult(winningLotto, lottoTickets, purchaseAmount);
        printLottoResult(lottoResult);
        inputHandler.closeConsole();
    }

    private LottoTickets issueLottoTickets(final PurchaseAmount purchaseAmount) {
        return lottoIssuer.issueLottoTickets(purchaseAmount);
    }

    private void printPurchaseResult(LottoTickets lottoTickets) {
        outputView.printCountOfLottoTickets(lottoTickets.size());
        outputView.printLottoTickets(lottoTickets);
    }

    private LottoResult getLottoResult(
            final WinningLotto winningLotto,
            final LottoTickets lottoTickets,
            final PurchaseAmount purchaseAmount
    ) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto);
        return lottoResultCalculator.getLottoResult(lottoTickets, purchaseAmount);
    }

    private void printLottoResult(final LottoResult lottoResult) {
        OutputView.printBlankLine();
        outputView.printWinningStatistics(lottoResult);
    }
}
