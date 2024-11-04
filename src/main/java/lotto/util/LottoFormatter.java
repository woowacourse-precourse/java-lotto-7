package lotto.util;

import lotto.domain.model.LottoRank;

import java.text.NumberFormat;

public class LottoFormatter {
    private static final String RANK_RESULT_FORMAT = "%s (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public static String formatRankResult(LottoRank rank, int count) {
        String formattedPrize = NumberFormat.getInstance().format(rank.getPrize());
        return String.format(RANK_RESULT_FORMAT, rank.getDescription(), formattedPrize, count);
    }

    public static String formatProfitRate(double profitRate) {
        return String.format(TOTAL_PROFIT_MESSAGE, profitRate);
    }
}