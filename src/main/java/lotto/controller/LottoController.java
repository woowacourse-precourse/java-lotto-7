package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.dto.BonusNumberRequest;
import lotto.dto.WinningNumbersRequest;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.vo.Count;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine,
                           LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        Lottos lottos = purchaseLottos(purchaseAmount);

        WinningNumbersRequest winningNumbers = inputWinningNumbers();
        BonusNumberRequest bonusNumber = inputBonusNumber(winningNumbers);

        calculateResults(lottos, winningNumbers, bonusNumber);
        displayResults(purchaseAmount);
    }

    private Lottos purchaseLottos(int purchaseAmount) {
        Count lottoCount = Count.newInstance(lottoMachine.calculateLottoCount(purchaseAmount));
        outputView.printPurchasedLottoCount(lottoCount.lottoCount());

        Lottos lottos = lottoMachine.issueLottoTickets(lottoCount.lottoCount());
        outputView.printLottoTickets(lottos);

        return lottos;
    }

    private int inputPurchaseAmount() {
        return inputView.readPurchaseAmount().getAmount();
    }

    private WinningNumbersRequest inputWinningNumbers() {
        return inputView.readWinningNumbers();
    }

    private BonusNumberRequest inputBonusNumber(WinningNumbersRequest winningNumbersRequest) {
        return inputView.readBonusNumber(winningNumbersRequest);
    }

    private void calculateResults(Lottos lottos, WinningNumbersRequest winningNumbers, BonusNumberRequest bonusNumber) {
        lottoService.processWinningResults(lottos, winningNumbers, bonusNumber);
    }

    private void displayResults(int purchaseAmount) {
        outputView.printResults(lottoService.getWinningResult());
        outputView.printProfitRate(lottoService.calculateTotalReturn(purchaseAmount));
    }
}
