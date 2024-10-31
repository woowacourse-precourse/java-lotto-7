package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class StatusMessage {

    private Map<Integer, String> message;

    public StatusMessage() {
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
        message.put(5000, "3개 일치 (5,000원) - ");
        message.put(50000, "4개 일치 (50,000원) - ");
        message.put(1500000, "5개 일치 (1,500,000원) - ");
        message.put(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        message.put(2000000000, "6개 일치 (2,000,000,000원) - ");
    }

}
