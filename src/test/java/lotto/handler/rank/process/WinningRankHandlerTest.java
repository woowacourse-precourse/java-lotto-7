package lotto.handler.rank.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.handler.purchase.dto.LottosDTO;
import lotto.handler.purchase.process.Lotto;
import lotto.handler.purchase.process.WinningRank;
import lotto.handler.rank.dto.RankCountsDTO;
import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankHandlerTest {
    private WinningRankHandler winningRankHandler;
    private HandlerToken handlerToken;

    @BeforeEach
    void 로또_당첨_등수_핸들러_핸들러_토큰_초기화() {
        winningRankHandler = new WinningRankHandler(new RankCounter());
        handlerToken = new HandlerToken();
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto thirdLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        LottosDTO lottosDTO = LottosDTO.create(List.of(firstLotto, secondLotto, thirdLotto));
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7");
        handlerToken.addContent(TokenType.LOTTOS_DTO, lottosDTO);
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        winningRankHandler.process(handlerToken);
        winningRankHandler.process(handlerToken);
    }

    @DisplayName("당첨 등수 핸들러의 process 시 핸들러 토큰에는 RankCountsDTO가 있어야함")
    @Test
    void 당첨_등수_핸들러_process_시_핸들러_토큰에_RankCountsDTO_존재() {
        Assertions.assertNotNull(handlerToken.getContent(TokenType.RANK_COUNTS_DTO, RankCountsDTO.class));
    }

    @DisplayName("process 시 핸들러 토큰의 RankCountsDTO에는 1등, 2등, 4등이 1개씩 있어야함")
    @Test
    void process_시_핸들러_토큰_RankCountsDTO에는_1_2_3_등_존재() {
        RankCountsDTO rankCountsDTO = handlerToken.getContent(TokenType.RANK_COUNTS_DTO, RankCountsDTO.class);
        HashMap<WinningRank, Integer> rankCounts = rankCountsDTO.getRankCounts();

        Map<WinningRank, Integer> expectedRankCounts = getExpectedRankCounts();

        expectedRankCounts.forEach((winningRank, expectedCount) ->
                assertEquals(expectedCount, rankCounts.get(winningRank)));
    }

    private Map<WinningRank, Integer> getExpectedRankCounts() {
        return Map.of(
                WinningRank.FIRST, 1,
                WinningRank.SECOND, 1,
                WinningRank.FOURTH, 1,
                WinningRank.THIRD, 0,
                WinningRank.FIFTH, 0
        );
    }
}