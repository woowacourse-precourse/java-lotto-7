package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @Test
    void 당첨로또_저장_성공_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Lotto savedLotto = lottoManager.saveWinningLotto(winningLotto);

        // then
        assertThat(savedLotto).isNotNull();
        assertThat(savedLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}