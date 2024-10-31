package lotto.domain.lotto.vo;

import lotto.domain.lotto.WinningLottoImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoImplTest {
    @Test
    @DisplayName("올바른 입력 값에 대해서 당첨 로또 객체를 생성할 수 있다.")
    void 정상_케이스() {
        // given
        List<Integer> winningInput = List.of(1, 2, 3, 4, 5, 6);
        final int bonusInput = 7;

        // when
        WinningLottoImpl winningLotto = WinningLottoImpl.of(winningInput, bonusInput);

        // then
        assertThat(winningLotto.basicNumbers()).containsSequence(winningInput);
        assertThat(winningLotto.bonusNumber()).isEqualTo(bonusInput);
    }

    @Test
    @DisplayName("로또 번호 범위를 넘어가는 숫자는 당첨 번호로 설정할 수 없다.")
    void 당첨_번호_범위_예외() {
        // given
        List<Integer> winningInput = List.of(46, 1, 2, 3, 4, 5);
        final int bonusInput = 6;

        // when & then
        assertThatThrownBy(() -> WinningLottoImpl.of(winningInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 넘어가는 숫자는 보너스 번호로 설정할 수 없다.")
    void 보너스_번호_범위_예외() {
        // given
        List<Integer> winningInput = List.of(1, 2, 3, 4, 5, 6);
        final int bonusInput = 0;

        // when & then
        assertThatThrownBy(() -> WinningLottoImpl.of(winningInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 숫자는 서로 중복될 수 없다.")
    void 당첨_번호_중복_예외() {
        // given
        List<Integer> winningInput = List.of(1, 2, 3, 4, 5, 5);
        final int bonusInput = 6;

        // when & then
        assertThatThrownBy(() -> WinningLottoImpl.of(winningInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 숫자와 보너스 숫자는 서로 중복될 수 없다.")
    void 보너스_중복_예외() {
        // given
        List<Integer> winningInput = List.of(1, 2, 3, 4, 5, 6);
        final int bonusInput = 1;

        // when & then
        assertThatThrownBy(() -> WinningLottoImpl.of(winningInput, bonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}