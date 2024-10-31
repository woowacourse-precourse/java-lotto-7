package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerCountList {
    private final List<WinnerCount> winnerCounts;
    private final TreeMap<Integer, Integer> rewardMap;

    public WinnerCountList() {
        this.winnerCounts = new ArrayList<>();
        this.rewardMap = new TreeMap<>();
    }

    public WinnerCountList(List<WinnerCount> winnerCounts) {
        this.winnerCounts = new ArrayList<>(winnerCounts);
        this.rewardMap = new TreeMap<>();
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

            rewardMap.merge(reward, 1, Integer::sum);
        }
        return new TreeMap<>(this.rewardMap); // 불변성을 유지하기 위해 복사본 반환
    }
}
