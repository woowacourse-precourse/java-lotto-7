package lotto;

import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @Test
    @DisplayName("로또는 정확히 6개의 번호를 포함해야 한다.")
    void 로또초기화_유효한버호_테스트() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 41, 42);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers())
                .hasSize(6)
                .as("로또는 정확히 6개의 번호를 포함해야 합니다.");
    }

    @Test
    @DisplayName("로또에 5개의 값이 입력되면 초기화에 실패해야 한다.")
    void 로또초기화_잘못된번호_테스트() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 41);
        Throwable thrown = catchThrowable(() -> new Lotto(numbers));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
