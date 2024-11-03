package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 보너스번호_중복시_예외_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoManager.saveWinningLotto(winningLotto);

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_검증_1미만인_경우_예외_테스트() {
        // given
        LottoManager lottoManager = new LottoManager();

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_검증_45초과인_경우_예외_테스트_46() {
        // given
        LottoManager lottoManager = new LottoManager();

        // when / then
        assertThatThrownBy(() -> lottoManager.saveBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}