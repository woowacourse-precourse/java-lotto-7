package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.WinningRankCountDto;

import java.util.List;

import static lotto.common.Constants.*;
import static lotto.domain.LottoRank.getLottoRanksWithoutNoRank;

public class OutputView {
    public static String getErrorMessage (String errorMessage) {
        return ERROR_PROMPT + errorMessage;
    }

    public static void printErrorMessage (String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottos (Lottos lottos) {
        printLineBreak();
        printLottoCount(lottos.size());

        List<String> lottosToString = lottos.lottosToString();

        for (String lottoToString: lottosToString) {
            System.out.println("[" + lottoToString + "]");
        }

        printLineBreak();
    }

    public void printWinningDetails (WinningRankCountDto winningRankCountDto) {
        List<LottoRank> availableRanks = getLottoRanksWithoutNoRank();

        System.out.println(RANK_DETAIL_PROMPT);

        for (LottoRank lottoRank : availableRanks) {
            Integer matchCount = lottoRank.getMatchCount();
            boolean hasBonusNumber = lottoRank.hasBonusNumber();

            Integer prizeMoney = lottoRank.getPrizeMoney();
            String formattedPrizeMoney = formatWithCommas(prizeMoney);

            Long winningCount = winningRankCountDto.getRankCount(lottoRank);

            printWinningDetail(matchCount, formattedPrizeMoney, winningCount, hasBonusNumber);
        }
    }

    private void printWinningDetail(Integer matchCount, String prizeMoney, Long winningCount, boolean hasBonusNumber) {
        if (hasBonusNumber) {
            System.out.printf(WINNING_DETAIL_PROMPT, matchCount, prizeMoney, winningCount);
        }
        else if (!hasBonusNumber) {
            System.out.printf(WINNING_WITH_BONUS_NUMBER_DETAIL_PROMPT, matchCount, prizeMoney, winningCount);
        }
    }

    private void printLottoCount (Integer lottoTicketCount) {
        System.out.println(lottoTicketCount + LOTTO_TICKET_COUNT_PROMPT);
    }

    private void printLineBreak () {
        System.out.println();
    }


    public String formatWithCommas(long number) {
        return String.format("%,d", number);
    }

    public void printProfitRate(Double profitRate) {
        System.out.printf(PROFIT_RATE_PROMPT, profitRate);
    }
}
