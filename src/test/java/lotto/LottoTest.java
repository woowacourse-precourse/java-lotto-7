package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoTest {
    private final static String ERROR_MESSAGE = "[ERROR]";

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

    @Test
    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 유효한 경우 예외가 발생하지 않는다.")
    void 로또_번호가_유효한_경우_예외가_발생하지_않는다() {
        assertThatNoException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("보너스 볼이 로또 번호와 중복되면 예외가 발생한다.")
    void 보너스_볼이_로또_번호와_중복되면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.validateBonusBall(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 볼이 로또 번호와 중복되지 않으면 예외가 발생하지 않는다.")
    void 보너스_볼이_로또_번호와_중복되지_않으면_예외가_발생하지_않는다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatNoException().isThrownBy(() -> lotto.validateBonusBall(7));
    }

    @Test
    @DisplayName("보너스 볼이 범위를 벗어나면 예외가 발생한다.")
    void 보너스_볼이_범위를_벗어나면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.validateBonusBall(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() -> lotto.validateBonusBall(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
