package lotto.view;

import static lotto.constant.Constants.DEFAULT_STATISTIC_COUNT;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.PurchaseOutputMessage;
import lotto.constant.StatisticsOutputMessage;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);


    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.printf(PurchaseOutputMessage.NUMBER_OF_PURCHASED_LOTTO.getMessage(), purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResults(Map<Rank, Integer> results) {
        System.out.println(StatisticsOutputMessage.START_COMMENT.getMessage());
        System.out.println(StatisticsOutputMessage.START_LINE.getMessage());

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = results.getOrDefault(rank, DEFAULT_STATISTIC_COUNT);
            String formattedPrize = numberFormat.format(rank.getPrizeMoney());

            if (rank == Rank.SECOND) {
                System.out.printf(StatisticsOutputMessage.CONTENT_OF_RESULT_FOR_BONUS_NUMBER.getMessage(),
                        rank.getMatchCount(), formattedPrize, count);
            }

            if (rank != Rank.SECOND) {
                System.out.printf(StatisticsOutputMessage.CONTENT_OF_LOTTO_RESULT.getMessage(),
                        rank.getMatchCount(), formattedPrize, count);
            }
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(StatisticsOutputMessage.PROFIT_RATE.getMessage(), profitRate);
    }
}