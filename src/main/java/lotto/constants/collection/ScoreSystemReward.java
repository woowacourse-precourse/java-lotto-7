package lotto.constants.collection;

import lotto.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * ScoreSystem의 조합 순서에 맞게 Reward가 List에 들어가 있습니다.
 */
public enum ScoreSystemReward implements Constants<List> {
    DEFAULT(List.of(5000,
            50000,
            1500000,
            30000000,
            2000000000));

    private List<Integer> rewards;

    ScoreSystemReward(List<Integer> rewards) {
        this.rewards = rewards;
    }

    //방어적 복사
    @Override
    public List<Integer> getInstance() {
        return new ArrayList<>(rewards);
    }
}
