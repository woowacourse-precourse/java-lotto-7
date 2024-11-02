package lotto.domain;

import java.util.Comparator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @NullAndEmptySource
    @MethodSource("testSize")
    void 중복되지않은_번호가_6개가_아니면_에러를_던진다(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(numbers);
        });
    }

    private static Stream<Arguments> testSize() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 6, 7))
        );
    }

    @Test
    void 로또번호는_오름차순으로_반환한다() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).isSortedAccordingTo(Comparator.naturalOrder());
    }
}
