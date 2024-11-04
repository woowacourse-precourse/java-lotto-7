package lotto.fixture;

import java.util.Map;
import lotto.domain.Prize;

public class PrizeResultFixture {

    public static Map<Prize, Integer> createTestPrizeResults() {
        return Map.of(Prize.FIRST, 0, Prize.SECOND, 0, Prize.THIRD, 0, Prize.FOURTH, 0, Prize.FIFTH, 1);
    }
}
