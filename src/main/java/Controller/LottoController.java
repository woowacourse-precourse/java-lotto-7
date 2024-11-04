package Controller;

import model.Lotto;
import model.LottoMachine;
import model.WinningNumbers;
import model.WinningRank;
import View.InputView;
import View.ResultView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        int money = Integer.parseInt(InputView.inputPurchaseAmount());
        lottoMachine.buyLottoTickets(money);
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        ResultView.printPurchasedLottos(lottoTickets);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNums = new WinningNumbers(winningNumbers, bonusNumber);

        int[] resultCount = new int[WinningRank.values().length];
        for (Lotto lotto : lottoTickets) {
            int matchCount = winningNums.calculateMatchCount(lotto);
            boolean hasBonus = winningNums.hasBonusNumber(lotto);
            WinningRank rank = WinningRank.valueOf(matchCount, hasBonus);
            resultCount[rank.ordinal()]++;
        }

        double profitRate = calculateProfitRate(resultCount);
        ResultView.printWinningStatistics(resultCount, profitRate);
    }

    private double calculateProfitRate(int[] resultCount) {
        double totalPrize = 0;
        for (WinningRank rank : WinningRank.values()) {
            totalPrize += resultCount[rank.ordinal()] * rank.getPrize();
        }
        double cost = lottoMachine.getLottoTickets().size() * 1000;
        return (totalPrize / cost) * 100;
    }
}