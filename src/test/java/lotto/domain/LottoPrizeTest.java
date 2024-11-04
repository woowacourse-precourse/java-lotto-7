package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {
    @Test
    void 일치하는_로또_번호_개수에_맞는_enum을_반환하는지_테스트() {
        Assertions.assertThat(LottoPrize.valueOf(6, false))
                .isEqualTo(LottoPrize.FIRST);
        Assertions.assertThat(LottoPrize.valueOf(5, true))
                .isEqualTo(LottoPrize.SECOND);
        Assertions.assertThat(LottoPrize.valueOf(5, false))
                .isEqualTo(LottoPrize.THIRD);
        Assertions.assertThat(LottoPrize.valueOf(4, false))
                .isEqualTo(LottoPrize.FOURTH);
        Assertions.assertThat(LottoPrize.valueOf(4, true))
                .isEqualTo(LottoPrize.FOURTH);
        Assertions.assertThat(LottoPrize.valueOf(3, false))
                .isEqualTo(LottoPrize.FIFTH);
        Assertions.assertThat(LottoPrize.valueOf(3, true))
                .isEqualTo(LottoPrize.FIFTH);
    }
}