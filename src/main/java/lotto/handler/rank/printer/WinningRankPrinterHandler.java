package lotto.handler.rank.printer;

import java.util.HashMap;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.process.WinningRank;
import lotto.handler.rank.dto.RankCountsDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class WinningRankPrinterHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        RankCountsDTO rankCountsDTO = getRankCountsDTOInHandlerToken(handlerToken);
        printRankCounts(rankCountsDTO.getRankCounts());
        return handlerToken;
    }

    private RankCountsDTO getRankCountsDTOInHandlerToken(HandlerToken handlerToken) {
        return handlerToken.getContent(TokenType.RANK_COUNTS_DTO, RankCountsDTO.class);
    }

    private void printRankCounts(HashMap<WinningRank, Integer> rankCounts) {
        System.out.print(DisplayFormat.STATISTICS_START.displayDefault());
        System.out.print(getFifthRankDisplay(rankCounts));
        System.out.print(getFourthRankDisplay(rankCounts));
        System.out.print(getThirdRankDisplay(rankCounts));
        System.out.print(getSecondRankDisplay(rankCounts));
        System.out.print(getFirstRankDisplay(rankCounts));
    }

    private String getFirstRankDisplay(HashMap<WinningRank, Integer> rankCounts) {
        return DisplayFormat.WINNING_RANK_FIRST.displayWithOneValue(rankCounts.get(WinningRank.FIRST));
    }

    private String getSecondRankDisplay(HashMap<WinningRank, Integer> rankCounts) {
        return DisplayFormat.WINNING_RANK_SECOND.displayWithOneValue(
                rankCounts.get(WinningRank.SECOND));
    }


    private String getThirdRankDisplay(HashMap<WinningRank, Integer> rankCounts) {
        return DisplayFormat.WINNING_RANK_THIRD.displayWithOneValue(rankCounts.get(WinningRank.THIRD));
    }


    private String getFourthRankDisplay(HashMap<WinningRank, Integer> rankCounts) {
        return DisplayFormat.WINNING_RANK_FOURTH.displayWithOneValue(
                rankCounts.get(WinningRank.FOURTH));
    }

    private String getFifthRankDisplay(HashMap<WinningRank, Integer> rankCounts) {
        return DisplayFormat.WINNING_RANK_FIFTH.displayWithOneValue(rankCounts.get(WinningRank.FIFTH));

    }
}
