package lotto.model.draw;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void 일치하는_숫자가_3개이면_5등_PRIZE를_획득합니다() {
        Prize prize = Prize.findPrize(3, false);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 일치하는_숫자가_4개이면_4등_PRIZE를_획득합니다() {
        Prize prize = Prize.findPrize(3, false);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 일치하는_숫자가_5개이고_보너스_넘버가_일치하지_않으면_3등_PRIZE를_획득합니다() {
        Prize prize = Prize.findPrize(5, false);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    void 일치하는_숫자가_5개이고_보너스_넘버가_일치하면_2등_PRIZE를_획득합니다() {
        Prize prize = Prize.findPrize(5, true);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    void 일치하는_숫자가_6개이면_1등_PRIZE를_획득합니다() {
        Prize prize = Prize.findPrize(6, false);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    void 당첨_개수에_맞는_상금을_계산하여_반환합니다() {
        int winningCount = 5;
        int sameNumberCount = 4;
        Prize prize = Prize.findPrize(sameNumberCount, false);
        assertThat(prize.calculatePrizeMoney(winningCount)).isEqualTo(250000);
    }

}
