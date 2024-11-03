package lotto.handler.statistics.process;

import java.util.HashMap;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.purchase.process.WinningRank;
import lotto.handler.rank.dto.RankCountsDTO;
import lotto.handler.statistics.dto.ProfitRateDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class StatisticsProcessHandler extends LottoHandler {
    private final StatisticsCalculator statisticsCalculator;

    public StatisticsProcessHandler(StatisticsCalculator statisticsCalculator) {
        this.statisticsCalculator = statisticsCalculator;
    }

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        RankCountsDTO rankCountsDTO = handlerToken.getContent(TokenType.RANK_COUNTS_DTO, RankCountsDTO.class);
        PurchaseAmountDTO purchaseAmountDTO = handlerToken.getContent(TokenType.PURCHASE_AMOUNT_DTO,
                PurchaseAmountDTO.class);
        HashMap<WinningRank, Integer> rankCounts = rankCountsDTO.getRankCounts();
        String purchaseAmount = purchaseAmountDTO.getPurchaseAmount();
        String profitRate = statisticsCalculator.calculate(rankCounts, Double.parseDouble(purchaseAmount));

        ProfitRateDTO profitRateDTO = ProfitRateDTO.create(profitRate);
        handlerToken.addContent(TokenType.PROFIT_RATE_DTO, profitRateDTO);

        return handlerToken;
    }
}
