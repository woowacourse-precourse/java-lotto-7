package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호는 6개의 서로 다른 숫자여야 합니다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 6개의 서로 다른 숫자여야 합니다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1에서 45 사이의 숫자여야 합니다.")
    @Test
    void 로또_번호의_범위가_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
