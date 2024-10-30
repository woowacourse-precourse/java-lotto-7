package lotto.controller;

import java.util.Map;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchaseDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.LottoRank;
import lotto.model.LottoSummary;

public class LottoSummaryController {

    public static LottoResultDTO calculateResult(WinningLottoDTO winningLotto, PurchaseDTO purchased) {
        LottoSummary summary = new LottoSummary(winningLotto.getWinningNumber(), winningLotto.getBonusNumber());

        Map<LottoRank, Integer> countResult = summary.countByLottoRank(purchased.getLottoTickets());
        Double profit = summary.calculateProfitPercentage(purchased.getTotalCost());

        return new LottoResultDTO(countResult, profit);
    }
}
