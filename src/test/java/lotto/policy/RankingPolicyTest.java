package lotto.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingPolicyTest {

    @Test
    void getPolicy() {
        //given
        RankingPolicy policy1 = RankingPolicy.getPolicy(3, false);
        RankingPolicy policy2 = RankingPolicy.getPolicy(4, false);
        RankingPolicy policy3 = RankingPolicy.getPolicy(5, false);
        RankingPolicy policy4Bonus = RankingPolicy.getPolicy(5, true);
        RankingPolicy policy5 = RankingPolicy.getPolicy(6, false);
        RankingPolicy policyNone = RankingPolicy.getPolicy(1, false);

        int prize1 = policy1.getPrize();
        int prize2 = policy2.getPrize();
        int prize3 = policy3.getPrize();
        int prize4 = policy4Bonus.getPrize();
        int prize5 = policy5.getPrize();
        int none = policyNone.getPrize();

        // when then
        Assertions.assertEquals(5000, prize1);
        Assertions.assertEquals(50_000, prize2);
        Assertions.assertEquals(1_500_000, prize3);
        Assertions.assertEquals(30_000_000, prize4);
        Assertions.assertEquals(2_000_000_000, prize5);
        Assertions.assertEquals(0, none);
    }
}