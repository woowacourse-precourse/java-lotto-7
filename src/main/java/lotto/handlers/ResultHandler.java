package lotto.handlers;

import lotto.models.LottoResults;
import lotto.utils.Decimals;

import java.util.List;
import java.util.stream.Stream;

public class ResultHandler {
    private final LottoResults lottoResults;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    public ResultHandler(LottoResults lottoResults) {
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
        double profit = (double) this.purchaseAmount / totalRewards;
        double roundedProfit = Decimals.round(profit, 1);
    }
}
