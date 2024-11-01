package lotto.domain;

import static lotto.utils.Constants.FIFTH;
import static lotto.utils.Constants.FIRST;
import static lotto.utils.Constants.FOURTH;
import static lotto.utils.Constants.SECOND;
import static lotto.utils.Constants.THIRD;

import java.util.HashMap;
import java.util.Map;

public class RewardMessage {

    private final Map<Integer, String> message;

    public RewardMessage() {
        this.message = new HashMap<>();
        init();
    }

    public String explainReward(int reward) {
        if (!message.containsKey(reward)) {
            throw new IllegalArgumentException("잘못된 상금입니다!");
        }

        return message.get(reward);
    }

    private void init() {
        message.put(FIFTH, "3개 일치 (5,000원) - ");
        message.put(FOURTH, "4개 일치 (50,000원) - ");
        message.put(THIRD, "5개 일치 (1,500,000원) - ");
        message.put(SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        message.put(FIRST, "6개 일치 (2,000,000,000원) - ");
    }
}
