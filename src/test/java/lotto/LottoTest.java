package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void 로또_번호가_1보다_작으면_예외가_발생한다(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 50, 100})
    void 로또_번호가_45보다_크면_예외가_발생한다(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호와 일치하는 번호 개수를 정확히 계산한다.")
    @Test
    void matchCount_정확성_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.matchCount(other)).isEqualTo(3);
    }

    @DisplayName("로또 번호가 특정 숫자를 포함하는지 확인한다.")
    @Test
    void contains_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @DisplayName("로또 번호 리스트가 불변인지 확인한다.")
    @Test
    void getNumbers_불변성_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = lotto.getNumbers();

        assertThatThrownBy(() -> numbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
