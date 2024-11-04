package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void getPrize_1등_상금_반환_확인() {
        // given
        int matchCount = 6;

        // when
        int result = Prize.getPrize(matchCount, false);

        // then
        assertThat(result).isEqualTo(2_000_000_000);
    }

    @Test
    void getPrize_2등_상금_반환_확인() {
        // given
        int matchCount = 5;

        // when
        int result = Prize.getPrize(matchCount, true);

        // then
        assertThat(result).isEqualTo(30_000_000);
    }

    @Test
    void getPrize_3등_상금_반환_확인() {
        // given
        int matchCount = 5;

        // when
        int result = Prize.getPrize(matchCount, false);

        // then
        assertThat(result).isEqualTo(1_500_000);
    }

}