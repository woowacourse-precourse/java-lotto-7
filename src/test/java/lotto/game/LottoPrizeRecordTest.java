package lotto.game;

import lotto.dto.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeRecordTest {
    @DisplayName("로또 당첨 금액을 계산한다.")
    @Test
    void getLottoPrize() {
        // given
        LottoPrizeRecord lottoPrizeRecord = new LottoPrizeRecord();
        lottoPrizeRecord.updateResult(LottoPrize.BONUS);
        lottoPrizeRecord.updateResult(LottoPrize.THREE);

        // when
        int winningPrice = lottoPrizeRecord.computeWinningPrice();

        // then
        assertThat(winningPrice).isEqualTo(LottoPrize.THREE.getPrice() + LottoPrize.BONUS.getPrice());
    }
}