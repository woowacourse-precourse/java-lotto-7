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
    LottoService lottoService;
    WinningNumbersService winningNumbersService;


    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, WinningNumbersService winningNumbersService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.winningNumbersService = winningNumbersService;
    }

    public Player createPlayer(int purchaseAmount) {
        return new Player(purchaseAmount);
    }

    private void processPurchase(int purchaseAmount) {
        Player player = createPlayer(purchaseAmount);
        int ticketCount = lottoService.calculateTicketCount(player.getPurchaseAmount());
        outputView.purchaseLottoCountMessage(ticketCount);
    }

    //TODO:  분리 예정
    public void run() {
        outputView.purchaseLottoAmountMesssage();
        int perchaseAmount = inputView.getPurchaseAmount();

        Player player = new Player(perchaseAmount);

        lottoService.generateLottoTickets(player);

        processPurchase(player.getPurchaseAmount());

        outputView.printLottoNumbers(player.getLottoNumbers());

        outputView.enterWinningNumbers();
        winningNumbersService.inputWinningNumbers();

        player.setWinningNumbers(winningNumbersService.getWinningNumbers());

        outputView.enterBonusNumber();
        winningNumbersService.inputBonusNumber();

        outputView.WinningStatistics();

        outputView.matchWinningCount(player.checkWinning());

        outputView.promptTotalReturnRate(player.getRateOfReturn(player.getWinningMoney()));
    }
}
