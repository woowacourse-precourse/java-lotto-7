package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    private static final int UNIT = 1000;

    @BeforeEach
    void clearRanks() {
        Ranks.clearHitCount();
    }

    @DisplayName("기능 테스트: 로또 수익률 초기값 생성 확인")
    @Test
    void check_profit_rate() {
        int randomValue = Randoms.pickNumberInRange(UNIT, Integer.MAX_VALUE - 1);
        int randomInvestAmount = (randomValue / UNIT) * UNIT;

        Tickets tickets = new Tickets(randomInvestAmount);
        Prize prize = new Prize();
        prize.checkProfitRate(tickets);

        double initialProfitRate = prize.getProfitRate();
        assertEquals(initialProfitRate, 0.0);
    }
}