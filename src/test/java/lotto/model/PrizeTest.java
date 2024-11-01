package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    void 등수에_맞는_돈을_반환한다() {
        int numberOfMatch = 5;
        boolean isBonusMatch = true;
        Prize prize = Prize.getMoney(numberOfMatch, isBonusMatch);
        assertThat(prize).extracting("rank", "money")
                .contains(2, 30000000L);
    }
}