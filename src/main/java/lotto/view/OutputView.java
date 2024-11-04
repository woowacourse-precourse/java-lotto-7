package lotto.view;

import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PrizeRank;
import lotto.util.OutputMessage;

import java.util.HashMap;
import java.util.Map;

public class OutputView {
    private static final Map<PrizeRank, String> rankMessageMap = new HashMap<>();

    static {
        // Initialize the mapping of PrizeRank to messages
        rankMessageMap.put(PrizeRank.FIRST, OutputMessage.PrizeMessage.SIX_MATCHING.getMessage());
        rankMessageMap.put(PrizeRank.SECOND, OutputMessage.PrizeMessage.FIVE_MATCHING_WITH_BONUS.getMessage());
        rankMessageMap.put(PrizeRank.THIRD, OutputMessage.PrizeMessage.FIVE_MATCHING.getMessage());
        rankMessageMap.put(PrizeRank.FOURTH, OutputMessage.PrizeMessage.FOUR_MATCHING.getMessage());
        rankMessageMap.put(PrizeRank.FIFTH, OutputMessage.PrizeMessage.THREE_MATCHING.getMessage());
    }
    public static void printLottos(Lottos lottos) {
        System.out.println();
        int lottoSize = lottos.getLottosSize();
        System.out.println(lottoSize + OutputMessage.SUCCESS_TICKET_PURCHASE);
        for(int i = 0; i < lottoSize; i++) {
            System.out.println(lottos.getLotto(i).getNumbers());
        }
    }

    public static void displayPrizeResults(Map<PrizeRank, Prize> prizeMap) {
        System.out.println();
        System.out.println(OutputMessage.LOTTO_WINNING_STATISTIC);
        System.out.println(OutputMessage.DASH_LINES);
        for (PrizeRank rank : PrizeRank.values()) {
            Prize prize = prizeMap.get(rank);
            String message = rankMessageMap.get(rank);
            int count = (prize != null) ? prize.getCount() : 0;
            System.out.println(message + count + "개");
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf("%s%.1f%%입니다.\n", OutputMessage.TOTAL_PROFIT, profitRate * 100);
    }
}
