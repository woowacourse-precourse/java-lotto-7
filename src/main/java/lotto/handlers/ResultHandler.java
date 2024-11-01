package lotto.handlers;

import lotto.models.LottoResults;
import lotto.ui.OutputView;
import lotto.utils.Decimals;

import java.util.List;
import java.util.stream.Stream;

public class ResultHandler {
    private final LottoResults lottoResults;
    private final OutputView outputView;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    public ResultHandler(OutputView outputView, LottoResults lottoResults) {
        this.outputView = outputView;
        this.lottoResults = lottoResults;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setWinningTicket(String winningNumbers, String bonusNumber) {
        this.winningNumbers = Stream.of(winningNumbers.split(",")).map(Integer::parseInt).toList();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void printResults(LottoHandler lottoHandler) {
        lottoHandler.findMatches(this.winningNumbers, this.bonusNumber, this.lottoResults);
        long totalRewards = this.lottoResults.calculateRewards();
        double profit = (double) totalRewards / this.purchaseAmount * 100;
        double roundedProfit = Decimals.round(profit, 1);

        outputView.printLottoResults(this.lottoResults);
        outputView.printProfit(roundedProfit);
    }
}
