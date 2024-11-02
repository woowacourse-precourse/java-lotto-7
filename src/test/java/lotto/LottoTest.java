package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 중복된 수 없이 6개가 존재하면 정상적으로 저장된다. ")
    @Test
    void 로또_번호에_중복된_수_없이_6개가_존재하면_정상처리된다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호에 수가 존재하면 True를 반환한다. ")
    @Test
    void 로또_번호에_수가_존재하면_True를_반환한다() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(1)).isTrue();
    }

    @DisplayName("로또 번호에 수가 존재하지 않으면 False를 반환한다. ")
    @Test
    void 로또_번호에_수가_존재하면_False를_반환한다() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasNumber(7)).isFalse();
    }
}
