package lotto.controller;

import java.util.Map;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchaseDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.LottoRank;
import lotto.model.LottoStatistic;

public class LottoStatisticController {

    public static LottoResultDTO calculateResult(WinningLottoDTO winningLotto, PurchaseDTO purchased) {
        LottoStatistic summary = new LottoStatistic(winningLotto.getWinningNumber(), winningLotto.getBonusNumber());

        Map<LottoRank, Integer> countResult = summary.countByLottoRank(purchased.getLottoTickets());
        Long totalProfit = summary.calculateTotalRewards();
        Double netProfit = summary.calculateProfitPercentage(totalProfit, purchased.getTotalCost());

        return new LottoResultDTO(countResult, netProfit);
    }
}
