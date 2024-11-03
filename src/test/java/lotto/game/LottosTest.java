package lotto.game;

import lotto.dto.LottoPrize;
import lotto.dto.Buyer;
import lotto.dto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private final Lottos lottos = new Lottos();

    @DisplayName("로또 당첨 등수를 기록한다.")
    @Test
    void checkLottoPrize() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto lotto3 = new Lotto(List.of(11, 15, 16, 21, 31, 41));
        Lotto lotto4 = new Lotto(List.of(1, 2, 13, 4, 5, 6));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);

        String numbers = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        int bonusNumber = 13;
        Buyer buyer = new Buyer(winningNumbers, bonusNumber);

        // when
        LottoPrizeRecord lottoPrizeRecord = lottos.checkLottos(buyer);

        // then
        assertThat(lottoPrizeRecord.getResult().get(LottoPrize.THREE)).isEqualTo(1);
        assertThat(lottoPrizeRecord.getResult().get(LottoPrize.FOUR)).isEqualTo(0);
        assertThat(lottoPrizeRecord.getResult().get(LottoPrize.FIVE)).isEqualTo(0);
        assertThat(lottoPrizeRecord.getResult().get(LottoPrize.SIX)).isEqualTo(1);
        assertThat(lottoPrizeRecord.getResult().get(LottoPrize.BONUS)).isEqualTo(1);
    }

}