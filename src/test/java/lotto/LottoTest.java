package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생")
    @Test
    void validateLottoNumberSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생")
    @Test
    void validateDuplicateNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void validateNumberUnderMinRange(int number) {
        List<Integer> numbers = List.of(number, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생")
    @ParameterizedTest
    @ValueSource(ints = {46, 50, 100})
    void validateNumberOverMaxRange(int number) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, number);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("정상적인 로또 번호로 객체가 생성")
    @Test
    void createLottoSuccess() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers);
    }

    @DisplayName("당첨 번호와 일치하는 번호 개수를 정확히 계산")
    @Test
    void checkMatchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 포함 여부를 정확히 확인")
    @Test
    void checkBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsNumber(6)).isTrue();
        assertThat(lotto.containsNumber(7)).isFalse();
    }
}