package lotto.domain.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.rank.LottoPrice;

public class LottoStatistics {

    private static final int MAKE_PERCENTAGE = 100;
    private static final double ROUNDING_NUMBER = 100.0;
    private static final int FIRST_INDEX_NUMBER = 0;
    private static final String THOUSAND_MONEY_FROM = "%,d";

    public static Map<LottoPrice, Integer> makeRankToPrice(List<Integer> sortedRanks) {
        Map<LottoPrice, Integer> rankPrice = new LinkedHashMap<>();
        List<LottoPrice> lottoPrices = Arrays.stream(LottoPrice.values())
                .toList();

        for (int i = FIRST_INDEX_NUMBER; i < sortedRanks.size(); i++) {
            rankPrice.put(lottoPrices.get(i), sortedRanks.get(i));
        }

        return rankPrice;
    }

    public static double calculateReturnRate(double sumPrice, int money) {
        double returnRate = sumPrice / money * MAKE_PERCENTAGE;
        return Math.round(returnRate * MAKE_PERCENTAGE) / ROUNDING_NUMBER;
    }

    public static String makeKoreaMoneyForm(int price) {
        return String.format(THOUSAND_MONEY_FROM, price);
    }
}
