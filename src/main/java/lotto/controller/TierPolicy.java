package lotto.controller;

import java.util.List;
import lotto.domain.tier.Tier;

public interface TierPolicy {

    /**
     * 초기화는 반드시 1등->2등->3등->4등->5등 순이어야 한다.
     * @return 초기화된 등급List
     */
    List<Tier> initTiers();
}
