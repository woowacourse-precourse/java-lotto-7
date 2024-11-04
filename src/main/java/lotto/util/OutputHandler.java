package lotto.util;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.constant.LottoConfig.Rank;
import lotto.model.LottosPrizeCount;

import static lotto.constant.IOMessage.BLANK_LINE;
import static lotto.constant.IOMessage.OUTPUT_BONUS_RESULT;
import static lotto.constant.IOMessage.OUTPUT_COUNT;
import static lotto.constant.IOMessage.OUTPUT_HEAD;
import static lotto.constant.IOMessage.OUTPUT_RATE_OF_RETURN;
import static lotto.constant.IOMessage.OUTPUT_RESULT;

public class OutputHandler {

    public static void printCount(int count) {
        output(BLANK_LINE.getMessage());
        output(String.format(OUTPUT_COUNT.getMessage(), count));
    }

    public static void printTicket(Lottos lottos) {
        for (Lotto lotto : lottos.getTickets()) {
            output(lotto.getNumbers().toString());
        }
    }

    public static void printLottoResult(LottosPrizeCount prizeCount) {
        output(BLANK_LINE.getMessage());
        output(OUTPUT_HEAD.getMessage());
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            Integer count = prizeCount.getCountForRank(rank);
            output(getLottoResultForm(rank, count));
        }
    }

    private static String getLottoResultForm(Rank rank, Integer count) {
        String bonusMessageForm = "";
        if (rank == Rank.SECOND) {
            bonusMessageForm = OUTPUT_BONUS_RESULT.getMessage();
        }
        return String.format(OUTPUT_RESULT.getMessage(), rank.getMatchedCount(), bonusMessageForm, rank.getPrizeMoney(), count);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        output(String.format(OUTPUT_RATE_OF_RETURN.getMessage(), rateOfReturn));
    }

    private static void output(String message) {
        System.out.println(message);
    }
}
