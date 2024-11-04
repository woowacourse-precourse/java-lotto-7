package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 티켓은")
class LottoTest {

    @ParameterizedTest
    @MethodSource("outOfRangeNumbers")
    void 번호_개수가_6개가_넘어가면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> outOfRangeNumbers() {
        return Stream.of(
            List.of(1),
            List.of(1, 2, 3),
            List.of(1, 2, 3, 4, 5),
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("duplicatedNumbers")
    void 번호_중_중복된_숫자가_있으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> duplicatedNumbers() {
        return Stream.of(
            List.of(1, 2, 3, 4, 5, 1),
            List.of(1, 1, 3, 4, 5, 6),
            List.of(1, 1, 1, 1, 1, 1),
            List.of(1, 2, 3, 3, 2, 1)
        );
    }
}
