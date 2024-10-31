package lotto;

import java.util.List;

public class LottoStatistics {

    public static double calcRateOfReturn(int investmentMoney, List<LottoRank> lottoRanks) {
        double totalPrizeMoney = 0;

        for (LottoRank lottoRank : lottoRanks) {
            totalPrizeMoney += lottoRank.getPrizeMoney();
        }

        return (totalPrizeMoney / investmentMoney) * 100;
    }
}
