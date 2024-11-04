package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("숫자가 큰 경우 예외가 발생한다.")
    @Test
    void 숫자가_큰_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 제거 시 숫자가 6개인 경우 예외가 발생한다.")
    @Test
    void 중복_제거시_숫자가_6개_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 음수인 경우 예외가 발생한다.")
    @Test
    void 숫자가_음수인_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -9)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
