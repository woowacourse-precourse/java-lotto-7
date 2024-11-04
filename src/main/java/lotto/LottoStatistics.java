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
        Map<LottoRank, Integer> winningCntPerRank = new HashMap<>();

        // key 설정
        for (LottoRank lottoRank : LottoRank.values()) {
            winningCntPerRank.put(lottoRank, 0);
        }

        // value 설정
        for (LottoRank lottoRank : lottoRanks) {
            int count = winningCntPerRank.get(lottoRank);
            count++;
            winningCntPerRank.put(lottoRank, count);
        }

        return winningCntPerRank;
    }
}
