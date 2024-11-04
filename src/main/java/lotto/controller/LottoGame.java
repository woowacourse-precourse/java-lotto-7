package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.service.WinningResultService;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

public class LottoGame {

    private final WinningResultService winningResultService;

    public LottoGame() {
        this.winningResultService = new WinningResultService();
    }

    public void play() {
        LottoPurchaseMoney purchaseAmount = InputHandler.getPurchaseAmount();
        LottoTickets lottoTickets = new LottoTickets(purchaseAmount);

        OutputHandler.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = InputHandler.getWinningLotto();
        WinningResult winningResult = winningResultService.determineWinningRanks(lottoTickets, winningLotto);
        int totalPrize = winningResult.calculateTotalPrize();
        double profitRate = winningResultService.calculateProfitRate(totalPrize, purchaseAmount.getAmount());

        OutputHandler.printWinningStatistics(winningResult, profitRate);

        Console.close();
    }
}
