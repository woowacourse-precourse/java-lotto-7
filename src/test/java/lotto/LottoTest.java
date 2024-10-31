package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 초과이면 예외가 발생한다.")
    @Test
    void validateLottoNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(46)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다.")
    @Test
    void validateLottoNumberRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
