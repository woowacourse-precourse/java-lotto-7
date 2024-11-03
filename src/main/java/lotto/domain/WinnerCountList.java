package lotto.domain;


import static lotto.utils.Reward.FIFTH;
import static lotto.utils.Reward.FIRST;
import static lotto.utils.Reward.FOURTH;
import static lotto.utils.Reward.SECOND;
import static lotto.utils.Reward.THIRD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerCountList {
    private final List<WinnerCount> winnerCounts;
    private final Map<Integer, Integer> rewardMap;

    private WinnerCountList(List<WinnerCount> winnerCounts) {
        this.winnerCounts = winnerCounts;
        this.rewardMap = initializeRewardMap();
    }

    public static WinnerCountList of(LottoList lottoList, WinnerLotto winnerLotto) {
        List<WinnerCount> counts = calculateWinnerCounts(lottoList, winnerLotto);
        return new WinnerCountList(counts);
    }

    private static List<WinnerCount> calculateWinnerCounts(LottoList lottoList, WinnerLotto winnerLotto) {
        List<WinnerCount> counts = new ArrayList<>();
        lottoList.forEach(lotto -> counts.add(winnerLotto.countWinnerMatch(lotto)));
        return counts;
    }

    protected Map<Integer, Integer> calculateAllReward() {
        for (WinnerCount winnerCount : winnerCounts) {
            Integer reward = winnerCount.calculateReward();

            rewardMap.computeIfPresent(reward, (key, value) -> value + 1);
        }
        return new TreeMap<>(this.rewardMap);
    }

    private Map<Integer, Integer> initializeRewardMap() {
        List<Integer> reward = List.of(
                FIRST.getPrize(),
                SECOND.getPrize(),
                THIRD.getPrize(),
                FOURTH.getPrize(),
                FIFTH.getPrize());
        Map<Integer, Integer> rewardMap = new TreeMap<>();

        for (Integer amount : reward) {
            rewardMap.put(amount, 0);
        }

        return rewardMap;
    }
}
