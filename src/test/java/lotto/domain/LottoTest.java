package lotto.domain;

import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 로또_번호가_1부터_45_범위를_벗어나면_예외가_발생한다() {
        // 번호 중 하나가 0일 때 (범위 아래)
        assertThatThrownBy(() -> LottoValidator.validate(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        // 번호 중 하나가 46일 때 (범위 위)
        assertThatThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 로또_번호가_정상적인_범위와_개수이면_통과한다() {
        assertThatNoException().isThrownBy(() -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 6)));
        assertThatNoException().isThrownBy(() -> LottoValidator.validate(List.of(12, 34, 23, 5, 44, 3)));
    }
}

