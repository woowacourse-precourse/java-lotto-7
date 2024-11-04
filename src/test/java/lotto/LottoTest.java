package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호에 음의 정수가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_음의_정수가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 되지않으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_되지않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호가 1~45 사이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_사이의_숫자가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 88, 61, 30)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}