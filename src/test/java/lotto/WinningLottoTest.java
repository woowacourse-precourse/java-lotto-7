package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @DisplayName("당첨 번호가 정상적일 경우")
    @Test
    void winningLottoSuccessTest() {
        assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우")
    @Test
    void winningLottoFailTest1() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우")
    @Test
    void winningLottoFailTest2() {
        assertThatThrownBy(() -> new WinningLotto(List.of(2, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위를 벗어날 경우")
    @Test
    void winningLottoFailTest3() {
        assertThatThrownBy(() -> new WinningLotto(List.of(60, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정상적으로 입력될 경우")
    @Test
    void winningLottoBonusNumberSuccessTest() {
        assertThatCode(() -> {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            winningLotto.setBonusNumber(7);
        })
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우")
    @Test
    void winningLottoBonusNumberFailTest1() {
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            winningLotto.setBonusNumber(1);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어날 경우")
    @Test
    void winningLottoBonusNumberFailTest2() {
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            winningLotto.setBonusNumber(60);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1등 테스트")
    @Test
    void winningLottoMatchSuccessTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), Optional.of(7));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.match(lotto)).isEqualTo(LottoResult.FIRST);
    }

    @DisplayName("로또 1등 테스트")
    @Test
    void winningLottoMatchSuccessTest2() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), Optional.of(7));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.match(lotto)).isEqualTo(LottoResult.SECOND);
    }


    @DisplayName("로또 보너스 번호가 입력되지 않은 경우")
    @Test
    void winningLottoMatchFailTest1() {
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            winningLotto.match(lotto);
        })
                .isInstanceOf(IllegalStateException.class);
    }
}
