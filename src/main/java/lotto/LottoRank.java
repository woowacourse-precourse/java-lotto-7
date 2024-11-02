package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoRank {
    NONE(0, false, 0, 0),
    FIFTH(3, false, 5, 5000),
    FOURTH(4, false, 4, 50000),
    THIRD(5, false, 3, 1500000),
    SECOND(5, true, 2, 30000000),
    FIRST(6, false, 1, 2000000000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int rank;
    private final int prize;

    LottoRank(int matchCount, boolean bonusMatch, int rank, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.rank = rank;
        this.prize = prize;
    }

    public static LottoRank valueOf(int point, boolean bonusMatch) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == point && lottoRank.bonusMatch == bonusMatch) {
                return lottoRank;
            }
        }
        return NONE;
    }

    public static Integer calculateTotalPrize(List<LottoRank> lottoRanks) {
        Integer totalPrize = 0;

        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.prize;
        }
        return totalPrize;
    }

    public static Map<LottoRank, Integer> lottoRankCounts(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> lottoRankCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            lottoRankCounts.put(rank, 0);
        }

        for (LottoRank lottoRank : lottoRanks) {
            lottoRankCounts.put(lottoRank, lottoRankCounts.get(lottoRank) + 1);
        }
        return lottoRankCounts;
    }

    public static void printLottoRanks(Map<LottoRank, Integer> lottoRankCounts) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank != NONE) {
                int count = lottoRankCounts.get(lottoRank);
                String bonusInfo = lottoRank.bonusMatch ? ", 보너스 볼 일치" : "";
                System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                        lottoRank.matchCount,
                        bonusInfo,
                        lottoRank.prize,
                        count);
            }
        }
    }
}
