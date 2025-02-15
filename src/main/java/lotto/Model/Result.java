package lotto.Model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import lotto.Utils;

public class Result {
    public final EnumMap<Rank, Integer> rankCounts;

    public Result() {
        this.rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.FIRST, 0);
        rankCounts.put(Rank.SECOND, 0);
        rankCounts.put(Rank.THIRD, 0);
        rankCounts.put(Rank.FOURTH, 0);
        rankCounts.put(Rank.FIFTH, 0);

    }

    public void compareLottos(List<Lotto> lottos, List<Integer> winningNums, int bonusNum) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNums::contains)
                    .count();

            boolean hasBonus = lotto.getNumbers().contains(bonusNum);

            Rank rank = Rank.getRank(matchCount, hasBonus);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    public void calcRevenue(int lottoAmount) {
        List<Rank> orderedRanks = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        Long revenue = 0L;
        for (Rank rank : orderedRanks) {

            System.out.println(Utils.printRanktoString(rank, rankCounts));
            revenue += (rank.getPrize() * rankCounts.get(rank));
        }
        Utils.printRevenue(revenue, lottoAmount);
    }
}