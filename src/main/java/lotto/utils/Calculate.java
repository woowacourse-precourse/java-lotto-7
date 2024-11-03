package lotto.utils;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.PurchasedPrice;

public class Calculate {
    public static double profitRate(LottoRanks lottoRanks, PurchasedPrice purchasedPrice) {
        long totalPrize = totalPrize(lottoRanks);
        return (double) totalPrize / purchasedPrice.getPurchasedPrice() * 100;
    }

    public static long totalPrize(LottoRanks lottoRanks) {
        long totalPrize = 0;
        for(LottoRank lottoRank : lottoRanks.getRanks()) {
            totalPrize += (long) lottoRank.getPrize() * lottoRank.getWinningCount();
        }
        return totalPrize;
    }
}
