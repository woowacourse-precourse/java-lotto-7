package lotto.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.calculator.EarningsRateCalculator;
import lotto.domain.calculator.WinningAmountCalculator;
import lotto.domain.calculator.WinningResultsCalculator;
import lotto.domain.model.RankInfo;

public class LottoService {
    private Map<RankInfo, Integer> winningResults;
    private BigDecimal winningAmount;
    private String earningsRate;

    public LottoService(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber, int purchaseAmount) {
        calculateWinningResults(lottoTickets, winningNumbers, bonusNumber);
        calculateWinningAmount(winningResults);
        calculateEarningResults(BigDecimal.valueOf(purchaseAmount), winningAmount);
    }

    private void calculateWinningResults(List<Lotto> lottoTickets, Lotto winningNumbers, Lotto bonusNumber) {
        WinningResultsCalculator winningResultsCalculator = new WinningResultsCalculator(lottoTickets, winningNumbers, bonusNumber);
        this.winningResults = winningResultsCalculator.getWinningResults();
    }

    private void calculateWinningAmount(Map<RankInfo, Integer> winningResults) {
        WinningAmountCalculator winningAmountCalculator = new WinningAmountCalculator(winningResults);
        this.winningAmount = winningAmountCalculator.getWinningAmount();
    }

    private void calculateEarningResults(BigDecimal purchaseAmount, BigDecimal winningAmount) {
        EarningsRateCalculator earningsRateCalculator = new EarningsRateCalculator(purchaseAmount, winningAmount);
        this.earningsRate = earningsRateCalculator.getEarningsRate();
    }

    // 테스트용 함수
    public String getWinningAmount() {
        return this.winningAmount.toPlainString();
    }

    public String getEarningsRate() {
        return this.earningsRate;
    }

    public Map<RankInfo, Integer> getWinningResults() {
        return new HashMap<>(winningResults);
    }
}
