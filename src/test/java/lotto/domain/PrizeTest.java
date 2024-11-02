package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("당첨 갯수의 따른 등수 확인")
    void GradeTest() {
        assertThat(Prize.from(6, false)).isEqualTo(Prize.FIRST);
        assertThat(Prize.from(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.from(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.from(4, false)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.from(3, false)).isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("당첨 갯수가 2개 이하면 낙첨")
    void noPrizeTest() {
        assertThat(Prize.from(2, false)).isEqualTo(Prize.NONE);
        assertThat(Prize.from(1, false)).isEqualTo(Prize.NONE);
        assertThat(Prize.from(0, false)).isEqualTo(Prize.NONE);
    }
}
