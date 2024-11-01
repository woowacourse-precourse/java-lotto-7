package lotto.domain;

import static lotto.utils.Constants.FIFTH;
import static lotto.utils.Constants.FIRST;
import static lotto.utils.Constants.FOURTH;
import static lotto.utils.Constants.SECOND;
import static lotto.utils.Constants.THIRD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerCountList {
    private final List<WinnerCount> winnerCounts;
    private final TreeMap<Integer, Integer> rewardMap;

    public WinnerCountList() {
        this.winnerCounts = new ArrayList<>();
        this.rewardMap = init();
    }

    public static WinnerCountList of(LottoList lottoList, WinnerLotto winnerLotto) {
        return lottoList.countWinnerMatches(winnerLotto);
    }

    public void add(WinnerCount winnerCount) {
        winnerCounts.add(winnerCount);
    }

    protected Map<Integer, Integer> calculateAllReward() {
        for (WinnerCount winnerCount : winnerCounts) {
            Integer reward = winnerCount.calculateReward();

            if (reward == 0) {
                continue;
            }

            rewardMap.computeIfPresent(reward, (key, value) -> value + 1);
        }
        return new TreeMap<>(this.rewardMap);
    }

    private TreeMap<Integer, Integer> init() {
        List<Integer> reward = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);
        TreeMap<Integer, Integer> rewardMap = new TreeMap<>();
        for (Integer amount : reward) {
            rewardMap.put(amount, 0);
        }

        return rewardMap;
    }
}
