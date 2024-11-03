package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.service.LottoService;
import lotto.model.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView;
    InputView inputView;

    private Player player; // Player 인스턴스를 필드로 추가
    private int purchaseAmount; // 구매 금액을 필드로 추가

    LottoService lottoService;
    WinningNumbersService winningNumbersService;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoService lottoService,
                           WinningNumbersService winningNumbersService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
    }

    public void run() {
        setupLotto();
        progressLotto();
        resultLotto();
    }

    private void setupLotto() {
        outputView.purchaseLottoAmountMesssage();

        purchaseAmount = inputView.getPurchaseAmount();
        player = new Player(purchaseAmount);

        lottoService.generateLottoTickets(player);

        processPurchase();
    }

    private void progressLotto() {
        outputView.printLottoNumbers(player.getLottoNumbers());

        outputView.enterWinningNumbers();
        winningNumbersService.inputWinningNumbers();

        player.setWinningNumbers(winningNumbersService.getWinningNumbers());

        outputView.enterBonusNumber();
        winningNumbersService.inputBonusNumber();
    }

    private void resultLotto() {
        outputView.WinningStatistics();
        outputView.matchWinningCount(player.checkWinning());
        outputView.promptTotalReturnRate(player.getRateOfReturn(player.getWinningMoney()));
    }

    private void processPurchase() {
        int ticketCount = lottoService.calculateTicketCount(player.getPurchaseAmount());
        outputView.purchaseLottoCountMessage(ticketCount);
    }
}
