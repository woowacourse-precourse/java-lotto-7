package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoManagerTest {

    @DisplayName("모든 로또 상금을 계산한다.")
    @Test
    void calculateWinningAmount() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8))
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Bonus bonus = new Bonus(7);
        LottoManager lottoManager = new LottoManager(lottos, winningLotto, bonus);

        //when
        int winningAmount = lottoManager.calculateWinningAmount();

        //then
        Assertions.assertThat(winningAmount).isEqualTo(31550000);
    }
}
