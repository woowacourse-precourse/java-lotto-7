package Controller;

import model.Lotto;
import model.LottoMachine;
import model.WinningNumbers;
import View.InputView;
import View.ResultView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        int money = InputView.inputPurchaseAmount();
        lottoMachine.buyLottoTickets(money);
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        ResultView.printPurchasedLottos(lottoTickets);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNums = new WinningNumbers(winningNumbers, bonusNumber);

        int[] resultCount = new int[5];
        for (Lotto lotto : lottoTickets) {
            int matchCount = winningNums.calculateMatchCount(lotto);
            if (matchCount == 6) resultCount[0]++;
            else if (matchCount == 5 && winningNums.hasBonusNumber(lotto)) resultCount[1]++;
            else if (matchCount == 5) resultCount[2]++;
            else if (matchCount == 4) resultCount[3]++;
            else if (matchCount == 3) resultCount[4]++;
        }

        double profitRate = calculateProfitRate(resultCount);
        ResultView.printWinningStatistics(resultCount, profitRate);
    }

    private double calculateProfitRate(int[] resultCount) {
        double totalPrize = resultCount[0] * 2000000000 + resultCount[4] * 5000;
        double cost = lottoMachine.getLottoTickets().size() * 1000;
        return (totalPrize / cost) * 100;
    }
}