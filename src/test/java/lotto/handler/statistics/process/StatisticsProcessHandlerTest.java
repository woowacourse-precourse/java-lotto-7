package lotto.handler.statistics.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import lotto.handler.purchase.dto.PurchaseAmountDTO;
import lotto.handler.purchase.process.WinningRank;
import lotto.handler.rank.dto.RankCountsDTO;
import lotto.handler.statistics.dto.ProfitRateDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsProcessHandlerTest {
    private StatisticsProcessHandler statisticsProcessHandler;
    private HandlerToken handlerToken;
    private StatisticsCalculator statisticsCalculator;

    @BeforeEach
    void StatisticsProcessHandler_핸들러_토큰_수익률_계산기_초기화() {
        statisticsCalculator = new StatisticsCalculator();
        statisticsProcessHandler = new StatisticsProcessHandler(statisticsCalculator);
        handlerToken = new HandlerToken();
        HashMap<WinningRank, Integer> rankCounts = getTestRankCounts();

        RankCountsDTO rankCountsDTO = RankCountsDTO.create(rankCounts);
        PurchaseAmountDTO purchaseAmountDTO = PurchaseAmountDTO.create("5000");

        handlerToken.addContent(TokenType.RANK_COUNTS_DTO, rankCountsDTO);
        handlerToken.addContent(TokenType.PURCHASE_AMOUNT_DTO, purchaseAmountDTO);
        statisticsProcessHandler.process(handlerToken);
    }

    @DisplayName("process 시 HandlerToken에 ProfitRateDTO가 포함되어야 함")
    @Test
    void process_시_HandlerToken에_ProfitRateDTO_포함() {
        assertNotNull(handlerToken.getContent(TokenType.PROFIT_RATE_DTO, ProfitRateDTO.class));
    }

    @DisplayName("process 시 ProfitRateDTO에 올바른 수익률이 포함되어야 함")
    @Test
    void process_시_ProfitRateDTO_올바른_수익률_포함() {
        ProfitRateDTO profitRateDTO = handlerToken.getContent(TokenType.PROFIT_RATE_DTO, ProfitRateDTO.class);

        String expectedProfitRate = "1100.0";
        assertEquals(expectedProfitRate, profitRateDTO.getProfitRate());
    }

    @DisplayName("테스트용 등수 갯수")
    private HashMap<WinningRank, Integer> getTestRankCounts() {
        HashMap<WinningRank, Integer> testRankCounts = new HashMap<>();
        testRankCounts.put(WinningRank.FIRST, 0);
        testRankCounts.put(WinningRank.SECOND, 0);
        testRankCounts.put(WinningRank.THIRD, 0);
        testRankCounts.put(WinningRank.FOURTH, 1);
        testRankCounts.put(WinningRank.FIFTH, 1);
        return testRankCounts;
    }
}