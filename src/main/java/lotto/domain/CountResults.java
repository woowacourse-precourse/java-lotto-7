package lotto.domain;


import static lotto.utils.Reward.FIFTH;
import static lotto.utils.Reward.FIRST;
import static lotto.utils.Reward.FOURTH;
import static lotto.utils.Reward.SECOND;
import static lotto.utils.Reward.THIRD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountResults {
    private final List<CountResult> results;
    private final Map<Integer, Integer> rewardMap;

    private CountResults(List<CountResult> results) {
        this.results = results;
        this.rewardMap = initializeRewardMap();
    }

    public static CountResults of(LottoTickets lottoTickets, WinnerLotto winnerLotto) {
        List<CountResult> counts = calculateWinnerCounts(lottoTickets, winnerLotto);
        return new CountResults(counts);
    }

    private static List<CountResult> calculateWinnerCounts(LottoTickets lottoTickets, WinnerLotto winnerLotto) {
        List<CountResult> counts = new ArrayList<>();
        lottoTickets.forEach(lotto -> counts.add(winnerLotto.countWinnerMatch(lotto)));
        return counts;
    }

    protected Map<Integer, Integer> calculateAllReward() {
        Map<Integer, Integer> resultMap = new TreeMap<>(this.rewardMap);

        for (CountResult countResult : this.results) {
            Integer reward = countResult.calculateReward();
            resultMap.computeIfPresent(reward, (key, value) -> value + 1);
        }

        return Collections.unmodifiableMap(resultMap);
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
