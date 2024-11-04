package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 객체 테스트")
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

    @DisplayName("로또 번호가 1에서 45 사이가 아니면 예외가 발생한다.")
    @Test
    void throwExceptionOverLimitNumber() {
        assertThatThrownBy(() -> Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1에서 45 사이의 숫자로만 이루어지면 예외가 발생하지 않는다")
    @Test
    void notThrowExceptionWithinValidRange() {
        assertThatCode(() -> Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 45)))
                .doesNotThrowAnyException();
    }
}
