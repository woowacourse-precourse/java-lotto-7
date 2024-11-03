package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    public void 일치하는_수에_따른_당첨_결과_확인() {
        assertThat(Prize.getPrize(5, true)).isEqualTo(Prize.BONUS);
        assertThat(Prize.getPrize(5, false)).isEqualTo(Prize.FIVE);
        assertThat(Prize.getPrize(3, false)).isEqualTo(Prize.THREE);
        assertThat(Prize.getPrize(2, false)).isEqualTo(Prize.NONE);
    }
}
