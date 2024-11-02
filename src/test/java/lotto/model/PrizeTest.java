package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    void 당첨되었을_경우_정상_작동한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 6, 8));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize).extracting("rank", "money")
                .contains(Prize.THIRD_PRIZE.getRank(), Prize.THIRD_PRIZE.getMoney());
    }
}