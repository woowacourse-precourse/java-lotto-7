package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    public static double calcRateOfReturn(int investmentMoney, List<LottoRank> lottoRanks) {
        double totalPrizeMoney = 0;

        for (LottoRank lottoRank : lottoRanks) {
            totalPrizeMoney += lottoRank.getPrizeMoney();
        }

        return (totalPrizeMoney / investmentMoney) * 100;
    }

    public static Map<LottoRank, Integer> calcRankStatistics(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> rankMap = new HashMap<>();

        // key 설정
        for (LottoRank lottoRank : LottoRank.values()) {
            rankMap.put(lottoRank, 0);
        }

        // value 설정
        for (LottoRank lottoRank : lottoRanks) {
            int count = rankMap.get(lottoRank);
            count++;
            rankMap.put(lottoRank, count);
        }

        return rankMap;
    }
}
