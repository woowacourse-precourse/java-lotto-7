package lotto.util;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.constant.LottoConfig.Rank;
import java.util.Map;

import static lotto.constant.IOMessage.BLANK_LINE;
import static lotto.constant.IOMessage.BONUS_MESSAGE;
import static lotto.constant.IOMessage.COUNT_MESSAGE;
import static lotto.constant.IOMessage.HEAD_MESSAGE;
import static lotto.constant.IOMessage.RATE_OF_RETURN_MESSAGE;
import static lotto.constant.IOMessage.RESULT_MESSAGE_FORMAT;
import static lotto.constant.SystemConfig.DEFAULT_VALUE;

public class OutputHandler {

    public static void printCount(int count) {
        output(BLANK_LINE);
        output(String.format(COUNT_MESSAGE, count));
    }

    public static void printTicket(Lottos lottos) {
        for(Lotto lotto : lottos.getTickets()){
            output(lotto.getNumbers().toString());
        }
    }

    public static void printLottoResult(Map<Rank, Integer> results) {
        output(BLANK_LINE);
        output(HEAD_MESSAGE);
        for(Rank rank : Rank.values()){
            if(rank == Rank.NOTHING) {
                continue;
            }
            Integer count = results.getOrDefault(rank, DEFAULT_VALUE);
            output(getLottoResultForm(rank, count));
        }
    }

    private static String getLottoResultForm(Rank rank, Integer count) {
        if(rank == Rank.SECOND) {
            return String.format(RESULT_MESSAGE_FORMAT, rank.getMatchedCount(), BONUS_MESSAGE, rank.getPrizeMoney(), count);
        }
        return String.format(RESULT_MESSAGE_FORMAT, rank.getMatchedCount(), "", rank.getPrizeMoney(), count);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        output(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }

    private static void output(String message) {
        System.out.println(message);
    }
}
