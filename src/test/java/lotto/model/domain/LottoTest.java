package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("provideInvalidNumberLists")
    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    void 로또_번호가_6개보다_적으면_예외가_발생한다(List<Integer> invalidNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLowNumbers")
    @DisplayName("로또 번호가 1미만의 숫자일 때 예외가 발생한다.")
    void 로또_번호가_1미만의_숫자일_때_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidHighNumbers")
    @DisplayName("로또 번호가 45를 초과하는 숫자일 때 예외가 발생한다.")
    void 로또_번호가_45를_초과하는_숫자일_때_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static List<List<Integer>> provideInvalidNumberLists() {
        return List.of(
                List.of(1, 2, 3, 4, 5) // 5개
        );
    }

    private static List<List<Integer>> provideInvalidLowNumbers() {
        return List.of(
                List.of(0, 1, 2, 3, 4, 5) // 0 포함
        );
    }

    private static List<List<Integer>> provideInvalidHighNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 46) // 46 포함
        );
    }

}
