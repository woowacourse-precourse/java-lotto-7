package lotto.domain;

import static lotto.utils.Reward.FIFTH;
import static lotto.utils.Reward.FIRST;
import static lotto.utils.Reward.FOURTH;
import static lotto.utils.Reward.SECOND;
import static lotto.utils.Reward.THIRD;

import java.util.Map;
import java.util.TreeMap;

public class RewardMessage {

    private final Map<Integer, String> message;

    public RewardMessage() {
        this.message = new TreeMap<>();
        init();
    }

    public String explainReward(int reward) {
        return message.get(reward);
    }

    private void init() {
        message.put(FIFTH.getPrize(), FIFTH.getDescription());
        message.put(FOURTH.getPrize(), FOURTH.getDescription());
        message.put(THIRD.getPrize(), THIRD.getDescription());
        message.put(SECOND.getPrize(), SECOND.getDescription());
        message.put(FIRST.getPrize(), FIRST.getDescription());
    }
}
