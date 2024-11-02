package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumberStatistics;
import lotto.model.LottoPlayer;
import lotto.view.input.LottoWinningNumber;
import lotto.view.input.PurchaseAmount;
import lotto.view.output.LottoPurchaseListPrinter;
import lotto.view.output.LottoWinningStatsPrinter;

public class LottoController {

    private final PurchaseAmount purchaseAmount = new PurchaseAmount();
    private final LottoWinningNumber winningNumber = new LottoWinningNumber();
    private final LottoPurchaseListPrinter purchaseListPrinter = new LottoPurchaseListPrinter();
    private final LottoWinningStatsPrinter winningStatsPrinter = new LottoWinningStatsPrinter();
    private final LottoNumberStatistics lottoNumberStatistics = new LottoNumberStatistics();
    private final LottoPlayer lottoPlayer = new LottoPlayer();
    private HashMap<Integer, String> winnerNumbers = new HashMap<>();
    private HashMap<Integer, Integer> winningResults = new HashMap<>();

    List<Lotto> lotteryTickets = new ArrayList<>();

    public void run() {
        int money = purchaseAmount.input();
        lotteryTickets = lottoPlayer.purchase(money);
        purchaseListPrinter.output(lotteryTickets);
        winnerNumbers = winningNumber.input();
        winningResults = lottoNumberStatistics.checkWinner(lotteryTickets, winnerNumbers);
        winningStatsPrinter.output(winningResults);
    }
}
