package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("1등 가격은 20억이다.")
    @Test
    void test1() {
        Rank twoMillon = Rank.FIRST;
        assertEquals(2000000000L, twoMillon.getMoney());
    }
}
