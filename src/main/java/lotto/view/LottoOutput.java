package lotto.view;

import lotto.constant.LottoConstant;
import lotto.constant.LottoPrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.dto.IssuedLottoDTO;
import lotto.dto.LottoWinStatisticDTO;

import java.util.List;

public class LottoOutput {
    public static void printIssuedLotto(IssuedLottoDTO issuedLottoDTO) {
        LottoRound lottoRound = issuedLottoDTO.lottoRound();

        System.out.println(String.format(LottoPrintMessage.RESPONSE_MESSAGE_ISSUE_COUNT_FORMAT, prettyPrint(lottoRound.getLottosCount())));
        for (Lotto lotto : lottoRound.getLottos()) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printWinStatistic(LottoWinStatisticDTO winStatistic) {
        System.out.println(LottoPrintMessage.RESPONSE_MESSAGE_STATISTIC_TITLE);
        printWinHistories(winStatistic.winLottoCount());
        printProfitRate(winStatistic.profitRate());
    }

    private static void printWinHistories(List<Integer> history) {
        int matchCount = 3;
        boolean pauseMatchCount = false;
        int[] prizes = LottoConstant.WINNING_PRIZE_VALUES;
        for (int i = 0; i < prizes.length; i++) {
            printWinHistory(pauseMatchCount, matchCount, prizes[i], history.get(5-i));
            matchCount++;

            if (pauseMatchCount) pauseMatchCount = false;
            if (i == 2) {
                pauseMatchCount = true;
                matchCount--;
            }
        }
    }

    private static void printWinHistory(boolean pauseMatchCount, int matchCount, int prize, int history) {
        String baseFormat = LottoPrintMessage.RESPONSE_MESSAGE_RANK_FORMAT;
        if (pauseMatchCount) baseFormat = LottoPrintMessage.RESPONSE_MESSAGE_RANK_WITH_BONUS_FORMAT;

        String formattedHistory = String.format(baseFormat, matchCount, prettyPrint(prize), prettyPrint(history));
        System.out.println(formattedHistory);
    }

    private static void printProfitRate(float profitRate) {
        String baseFormat = LottoPrintMessage.RESPONSE_MESSAGE_PROFIT_RATE_FORMAT;
        String formattedWinHistory = String.format(baseFormat, profitRate);

        System.out.println(formattedWinHistory);
    }

    public static String prettyPrint(int value) {
        String formattedPart = "";
        if (value > 1000) {
            formattedPart = prettyPrint(value / 1000);
            value %= 1000;
            formattedPart += ",";
        }

        String formattingPart = Integer.toString(value);
        if (!formattedPart.isEmpty()) {
            if (formattingPart.length() < 2) formattingPart = "0" + formattingPart;
            if (formattingPart.length() < 3) formattingPart = "0" + formattingPart;
        }
        return formattedPart + formattingPart;
    }
}
