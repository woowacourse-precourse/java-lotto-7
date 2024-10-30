package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.Exception.INVALID_LOTTO_NUMBERS_COUNT;
import static lotto.exception.Exception.LOTTO_NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBERS_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 1보다 작거나 45보다 큰 값이 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호가_1보다_작거나_45보다_크면_예외가_발생한다(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(invalidNumber, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("유효한 로또 번호가 입력될 경우 객체가 정상적으로 생성된다.")
    @Test
    void 유효한_번호가_입력되면_정상적으로_생성된다() {
        List<Integer> validNumbers  = List.of(1, 2, 3, 4, 5, 45);
        Lotto lotto  = new Lotto(validNumbers );

        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(validNumbers);
    }
}
