package controller;

import model.Lotto;
import model.LottoResult;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        try {
            int purchaseAmount = inputView.inputPurchaseCost();
            int ticketCount = purchaseAmount / 1000;

            outputView.printTicketCount(ticketCount);
            List<Lotto> lottos = lottoService.issueLottos(ticketCount);
            outputView.printLottos(lottos);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            lottoService.validateWinningNumbers(winningNumbers, bonusNumber);

            List<LottoResult> results = lottos.stream()
                    .map(lotto -> lottoService.checkWin(lotto, winningNumbers, bonusNumber))
                    .toList();

            outputView.printResults(results);
            double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
            outputView.printProfitRate(profitRate);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            start(); // 예외 발생 시 다시 시작
        }
    }
}
