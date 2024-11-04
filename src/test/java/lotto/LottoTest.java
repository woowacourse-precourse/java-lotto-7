package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.input.Input;
import lotto.provider.LottoProvider;
import lotto.user.User;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구입금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoProvider(1200, new User()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 클 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_45보다_클_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Input.validateLottoNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_1보다_작을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Input.validateLottoNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
