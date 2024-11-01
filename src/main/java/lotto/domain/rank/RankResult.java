package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.vo.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RankResult {
    private final HashMap<Rank, Integer> rankInfo;

    private RankResult(HashMap<Rank, Integer> rankInfo) {
        this.rankInfo = rankInfo;
    }

    public static RankResult from(List<Lotto> lottos, WinningLotto winningLotto) {
        HashMap<Rank, Integer> result = initRankInfo();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(winningLotto);
            if (rank != null) {
                result.put(rank, result.get(rank) + 1);
            }
        }

        return new RankResult(result);
    }

    private static HashMap<Rank, Integer> initRankInfo() {
        HashMap<Rank, Integer> initResult = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> {
            initResult.put(rank, 0);
        });
        return initResult;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        List<Rank> sortedRanks = Rank.getSortedRanks();
        sortedRanks.forEach(rank -> {
            stringBuffer.append(String.format("%s - %d개\n", rank.toString(), getCount(rank)));
        });
        return stringBuffer.toString();
    }

    public int getRevenue() {
        int revenue = 0;
        for (Rank rank : Rank.values()) {
            revenue += rank.getPrize() * getCount(rank);
        }
        return revenue;
    }

    private int getCount(Rank rank) {
        return rankInfo.get(rank);
    }
}
