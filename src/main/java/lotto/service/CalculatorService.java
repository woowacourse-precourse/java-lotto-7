package lotto.service;

import java.util.Arrays;
import lotto.constant.LottoRank;
import lotto.constant.LottoResultsTracker;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;

public class CalculatorService {
    private final WinningNumbersService winningNumbersService;

    public CalculatorService(WinningNumbersService winningNumbersService) {
        this.winningNumbersService = winningNumbersService;
    }

    public String profitCalculate(double lottoPrice, double profit) {
        if (profit == 0) {
            return "0%";
        }
        double rateOfReturn = profit / lottoPrice * 100;
        return String.format("%.1f%%", rateOfReturn);
    }

    public LottoResultsTracker calculateRankForWinningLotto(LottoTickets lottoTickets, WinningNumbers winningNumbers,
                                                            int bonus) {
        LottoResultsTracker lottoResultsTracker = new LottoResultsTracker();
        lottoTickets.streamLotto()
                .forEach(lotto -> {
                    LottoRank lottoRank = winningNumbersService.getLottoRank(lotto, winningNumbers, bonus);
                    lottoResultsTracker.incrementRankCount(lottoRank);
                });
        return lottoResultsTracker;
    }

    public double getProfit(LottoResultsTracker lottoResultsTracker) {
        return Arrays.stream(LottoRank.values()).
                mapToDouble(rank -> rank.prize * lottoResultsTracker.getRankCount(rank)).
                reduce(0, Double::sum);
    }

}
