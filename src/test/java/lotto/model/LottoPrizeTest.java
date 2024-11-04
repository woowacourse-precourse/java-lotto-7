package lotto.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPrizeTest {

    @Test
    void 일치하는_번호_개수와_보너스_여부에_따라_순위가_결정된다() {

        assertThat(LottoPrize.of(3, false)).isEqualTo(LottoPrize.FIFTH);
        assertThat(LottoPrize.of(4, false)).isEqualTo(LottoPrize.FOURTH);
        assertThat(LottoPrize.of(5, false)).isEqualTo(LottoPrize.THIRD);
        assertThat(LottoPrize.of(5, true)).isEqualTo(LottoPrize.SECOND);
        assertThat(LottoPrize.of(6, false)).isEqualTo(LottoPrize.FIRST);
        assertThat(LottoPrize.of(2, false)).isEqualTo(LottoPrize.ZERO);
        assertThat(LottoPrize.of(0, false)).isEqualTo(LottoPrize.ZERO);
    }

    @Test
    void 순위에_따라_상금이_결정된다() {
        assertThat(LottoPrize.FIFTH.getMatchCount()).isEqualTo(3);
        assertThat(LottoPrize.FIFTH.getPrizeAmount()).isEqualTo(5000);

        assertThat(LottoPrize.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(LottoPrize.FOURTH.getPrizeAmount()).isEqualTo(50000);

        assertThat(LottoPrize.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(LottoPrize.THIRD.getPrizeAmount()).isEqualTo(1500000);

        assertThat(LottoPrize.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(LottoPrize.SECOND.getPrizeAmount()).isEqualTo(30000000);
        assertThat(LottoPrize.SECOND.hasBonus()).isTrue();

        assertThat(LottoPrize.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(LottoPrize.FIRST.getPrizeAmount()).isEqualTo(2000000000);

        assertThat(LottoPrize.ZERO.getMatchCount()).isEqualTo(0);
        assertThat(LottoPrize.ZERO.getPrizeAmount()).isEqualTo(0);
    }
}
