package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("관리하고 있는 로또들의 개수를 반환한다.")
    void size() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        // when
        int size = lottos.size();
        // then
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("로또들의 당첨 결과를 가져온다.")
    void getResult() {
        // given
        Lottos lottos = new Lottos(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        // when
        LottoResult result = lottos.calculateResult(winningLotto);
        // then
        assertThat(result).isNotNull();
    }
}